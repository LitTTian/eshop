package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.TradeMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.user.User;
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


    @Override
    public List<Trade> getTradesByUserId(String userId) {
        return tradeMapper.selectByBuyerId(userId);
    }

    @Override
    public Trade getTradeDetailByTradeId(String tradeId) {
        return tradeMapper.selectByTradeId(tradeId);
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
}
