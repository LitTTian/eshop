package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.TradeDetailMapper;
import com.lrz.eshop.mapper.TradeMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.producer.DelayMessageProducer;
import com.lrz.eshop.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        trade.setState((short) 2);
        userMapper.updateById(user);
        tradeMapper.updateById(trade);
        return trade;
    }

    @Override
    public Trade cancelTrade(String userId, String tradeId) {
        Trade trade = tradeMapper.selectById(tradeId);
        if(trade == null || !userId.equals(String.valueOf(trade.getBuyerId())) || trade.getState() != 1) {
            return null;
        }
        trade.setState((short) 6); // 6:交易取消
        tradeMapper.updateById(trade);
        return trade;
    }

    @Override
    public Trade confirmReceipt(String userId, String tradeId) {
        Trade trade = tradeMapper.selectById(tradeId);
        if(trade == null || !userId.equals(String.valueOf(trade.getBuyerId())) || trade.getState() != 2) {
            return null;
        }
        trade.setState((short) 3); // 3:确认收货
        tradeMapper.updateById(trade);
        return trade;
    }



    @Override
    public void updateTradeStatus(Trade trade) {
        if(trade.getCreateTime().getTime() + 15 * 60 * 1000 >= System.currentTimeMillis() || trade.getState() != 1) {
            return;
        }
        // trade.setUpdateTime();
        trade.setState((short) 6); // 6:交易取消
        tradeMapper.updateById(trade);
    }

    @Override
    public void updateTradeListStatus(List<Trade> tradeList) {
        for(Trade trade : tradeList) {
            updateTradeStatus(trade);
        }
    }

    @Override
    public void updateTradeByUserId(String id) {
        updateTradeListStatus(tradeMapper.selectByBuyerId(id));
    }




}
