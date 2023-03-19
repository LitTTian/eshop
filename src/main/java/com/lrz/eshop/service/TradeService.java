package com.lrz.eshop.service;

import com.lrz.eshop.pojo.trade.Trade;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/8 20:02
 * @description
 */
public interface TradeService {


    List<Trade> getTradesByUserId(String userId);

    Trade getTradeDetailByTradeId(String tradeId);


    Trade payByTradeId(String userId, String tradeId);

}
