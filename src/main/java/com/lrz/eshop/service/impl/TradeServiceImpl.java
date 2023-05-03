package com.lrz.eshop.service.impl;

import com.lrz.eshop.common.aop.DBLoggerAnnotation;
import com.lrz.eshop.controller.dto.TradeDTO;
import com.lrz.eshop.controller.dto.TradeDetailDTO;
import com.lrz.eshop.mapper.product.ProductMapper;
import com.lrz.eshop.mapper.trade.TradeDetailMapper;
import com.lrz.eshop.mapper.trade.TradeMapper;
import com.lrz.eshop.mapper.user.UserMapper;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;
import com.lrz.eshop.pojo.trade.TradeState;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.producer.DelayMessageProducer;
import com.lrz.eshop.service.ImageService;
import com.lrz.eshop.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 天天
 * @create 2023/3/8 20:03
 * @description
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TradeDetailMapper tradeDetailMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ImageService imageService;

    @Autowired
    private DelayMessageProducer delayMessageProducer;

/*    @Override
    public Trade placeOrder(Trade trade) {
        insertTrade(trade);
        if(trade.getId() == null) {
            return null;
        }else {
            for(TradeDetail tradeDetail : trade.getTradeDetails()) {
                tradeDetail.setTradeId(trade.getId());
                insertTradeDetail(tradeDetail);
            }
            // 生成延迟消息
            delayMessageProducer.send(String.valueOf(trade.getId()), 15 * 60 * 1000);
            return trade;
        }
    }*/

    @Override
    // 新的placeOrder
    public List<Trade> placeOrderList(List<TradeDTO> tradeDTOs) {
        List<Trade> trades = new ArrayList<>();
        for(TradeDTO TradeDTO: tradeDTOs) {
            trades.add(placeOrder(TradeDTO));
        }
        return trades;
    }


    @Override
    @DBLoggerAnnotation(module = "订单", operation = "下单")
    public Trade placeOrder(TradeDTO tradeDTO) {
        List<TradeDetail> tradeDetails = new ArrayList<>();
        int index = 0;
        int totalCount = 0;
        float totalPrice = 0;
        float totalDiscount = 0;
        // 运费
        int totalTransportationExpenses = 0;
        for(TradeDetailDTO detail: tradeDTO.getTradeDetailDTOs()) {
            Product product = productMapper.selectById(detail.getProductId());
            int count = detail.getCount();
            float price = product.getPrice();
            float originPrice = product.getOriginalPrice();
            float discount = count * ( originPrice - price);
            totalCount += count;
            totalPrice += count * price;
            totalDiscount += discount;
            totalTransportationExpenses += 0;
            TradeDetail tradeDetail = new TradeDetail();
            // tradeDetail.setSellerId(Long.valueOf(tradeDTO.getSellerId())); // TODO 需要删除此字段
            tradeDetail.setProductId(Long.valueOf(detail.getProductId()));
            tradeDetail.setPrice(price);
            tradeDetail.setCount(count);
            tradeDetail.setDiscount(discount);
            tradeDetail.setTransportationExpenses(0);
            // TODO TradeDetail的imageUrl获取方式要修改
            // tradeDetail.setImageUrl(imageService.selectCoverImageUrlByProductId(detail.getProductId()).getImgUrl());
            tradeDetail.setImageUrl(detail.getImageUrl());
            tradeDetails.add(tradeDetail);
        }
        Trade trade = new Trade();
        trade.setSellerId(Long.valueOf(tradeDTO.getSellerId()));
        trade.setBuyerId(Long.valueOf(tradeDTO.getBuyerId()));
        trade.setLocationId(Long.valueOf(tradeDTO.getLocationId()));
        trade.setTotalCount(totalCount);
        trade.setTotalPrice(totalPrice);
        trade.setTotalDiscount(totalDiscount);
        trade.setTotalTransportationExpenses(totalTransportationExpenses);
        // 更新trade状态并插入数据库
        trade.setState(TradeState.WAIT_PAY.getCode());
        // 插入数据库后，trade有id了
        tradeMapper.insert(trade);
        if(trade.getId() == null) {
            return null;
        }else {
            for(TradeDetail detail: tradeDetails) {
                detail.setTradeId(trade.getId());
                tradeDetailMapper.insert(detail);
            }
        }
        delayMessageProducer.send(String.valueOf(trade.getId()), 15 * 60 * 1000);
        return trade;
    }
    @Override
    public Trade insertTrade(Trade trade) {
        tradeMapper.insert(trade);
        if(trade.getId() == null) {
            return null;
        }else {
            return trade;
        }
    }

    @Override
    public TradeDetail insertTradeDetail(TradeDetail tradeDetail) {
        tradeDetailMapper.insert(tradeDetail);
        if(tradeDetail.getId() == null) {
            return null;
        }else {
            return tradeDetail;
        }
    }

    @Override
    public List<Trade> getTradesByUserId(String userId) {
        return tradeMapper.selectByBuyerId(userId);
    }

    @Override
    public List<Trade> getTradesBySellerId(String sellerId) {
        return tradeMapper.selectBySellerId(sellerId);
    }

    @Override
    public Trade getTradeDetailByTradeId(String tradeId, String userId) {
        return tradeMapper.selectByTradeId(tradeId, userId);
    }


    @Override
    @DBLoggerAnnotation(module = "订单", operation = "通过tradeId支付")
    public Trade payByTradeId(String userId, String tradeId) {
        User user = userMapper.selectById(userId);
        Trade trade = tradeMapper.selectById(tradeId);
        if(user.getBalance() < trade.getTotalPrice()) {
            // 余额不足
            return null;
        }
        user.setBalance(user.getBalance() - trade.getTotalPrice());
        // trade.setState((short) 2); // 2:待发货
        updateState(trade, TradeState.WAIT_DELIVER.getCode());
        userMapper.updateById(user); // 更新用户余额
        tradeMapper.updateById(trade); // 更新订单状态
        return trade;
    }

    @Override
    @DBLoggerAnnotation(module = "订单", operation = "取消订单")
    public Trade verifyAndCancelTrade(String userId, String tradeId) {
        Trade trade = tradeMapper.selectById(tradeId);
        if(trade == null || !userId.equals(String.valueOf(trade.getBuyerId()))) {
            return null;
        }
        if(trade.getState() != TradeState.WAIT_PAY.getCode()) { // 1:待付款
            return null;
        }
        // trade.setState((short) 6); // 6:交易取消
        // tradeMapper.updateById(trade);
        cancelTrade(trade);
        return trade;
    }

    @DBLoggerAnnotation(module = "订单", operation = "用户确认收货")
    @Override
    public Trade confirmReceipt(String userId, String tradeId) {
        Trade trade = tradeMapper.selectById(tradeId);
        if(trade == null || !userId.equals(String.valueOf(trade.getBuyerId()))) {
            return null;
        }
        if(trade.getState() != TradeState.WAIT_DELIVER.getCode() && trade.getState() != TradeState.WAIT_RECEIVE.getCode()) { // 2:待发货 3:待收货
            return null;
        }

        updateState(trade, TradeState.RECEIVED.getCode()); // 4:确认收货
        // trade.setState((short) 4); // 4:确认收货
        // tradeMapper.updateById(trade);
        return trade;
    }

    @Override
    public void updateTradeState(Trade trade) {
        if(trade == null || trade.getCreateTime().getTime() + 15 * 60 * 1000 >= System.currentTimeMillis() || trade.getState() != TradeState.WAIT_PAY.getCode()) {
            return;
        }
        // trade.setUpdateTime();
        cancelTrade(trade); // 7:交易取消
    }

    @Override
    public void updateTradeListState(List<Trade> tradeList) {
        for(Trade trade : tradeList) {
            updateTradeState(trade);
        }
    }

    @Override
    public void updateTradeByUserId(String id) {
        updateTradeListState(tradeMapper.selectByBuyerIdAndState(id, TradeState.WAIT_PAY.getCode()));
    }



    @Override
    public int updateState(Trade trade, byte stateByte) {
        trade.setState(stateByte);
        return tradeMapper.updateById(trade);
    }

    @Override
    @DBLoggerAnnotation(module = "订单", operation = "卖家发货")
    public Trade deliverGoods(String sellerId, String tradeId, String expressCompany, String expressNumber) {
        Trade trade = tradeMapper.selectById(tradeId);
        if(trade == null || !sellerId.equals(String.valueOf(trade.getSellerId()))) {
            return null;
        }
        if(trade.getState() != TradeState.WAIT_DELIVER.getCode()) { // 2:待发货
            return null;
        }
        trade.setExpressCompany(expressCompany);
        trade.setExpressNumber(expressNumber);
        updateState(trade, TradeState.WAIT_RECEIVE.getCode()); // 3:待收货
        return trade;
    }

    @Override
    public int cancelTrade(Trade trade) {
        return updateState(trade, TradeState.CANCEL.getCode());
    }


}
