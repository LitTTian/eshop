package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.TradeDetailMapper;
import com.lrz.eshop.mapper.TradeMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;
import com.lrz.eshop.pojo.trade.TradeState;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.producer.DelayMessageProducer;
import com.lrz.eshop.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private DelayMessageProducer delayMessageProducer;

    @Override
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
    public Trade getTradeDetailByTradeId(String tradeId, String userId) {
        return tradeMapper.selectByTradeId(tradeId, userId);
    }


    @Override
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
    public int updateState(Trade trade, byte stateInt) {
        trade.setState(stateInt);
        return tradeMapper.updateById(trade);
    }

    @Override
    public int cancelTrade(Trade trade) {
        return updateState(trade, TradeState.CANCEL.getCode());
    }


}
