package com.lrz.eshop.service;

import com.lrz.eshop.pojo.trade.Trade;
import com.lrz.eshop.pojo.trade.TradeDetail;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/8 20:02
 * @description
 */
public interface TradeService {


    List<Trade> getTradesByUserId(String userId);

    /**
     * 获取订单详情，用于支付页面
     * @param tradeId
     * @param userId
     * @return
     */
    Trade getTradeDetailByTradeId(String tradeId, String userId);

    Trade payByTradeId(String userId, String tradeId);

    Trade verifyAndCancelTrade(String userId, String tradeId);

    Trade confirmReceipt(String userId, String tradeId);

    void updateTradeState(Trade trade);

    void updateTradeListState(List<Trade> tradeList);

    void updateTradeByUserId(String id);


    Trade placeOrder(Trade trade);

    Trade insertTrade(Trade trade);

    TradeDetail insertTradeDetail(TradeDetail tradeDetail);

    int cancelTrade(Trade trade);
    int updateState(Trade trade, byte state);

}
