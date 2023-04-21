package com.lrz.eshop.pojo.trade;

/**
 * @author 天天
 * @create 2023/4/20 22:29
 * @description
 */
public enum TradeState {
    // 订单状态：1，待付款；2，待发货；3，待收到；4，已收货；5，退货中；6，交易完成；7，订单取消/关闭
    WAIT_PAY(1, "待付款"),
    WAIT_DELIVER(2, "待发货"),
    WAIT_RECEIVE(3, "待收货"),
    RECEIVED(4, "已收货"),
    RETURNING(5, "退货中"),
    FINISH(6, "交易完成"),
    CANCEL(7, "订单取消/关闭");

    private byte code;
    private String desc;

    TradeState(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    TradeState(int code, String desc) {
        this.code = (byte) code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static TradeState getTradeStateByCode(byte code) {
        for(TradeState tradeState : TradeState.values()) {
            if(tradeState.getCode() == code) {
                return tradeState;
            }
        }
        return null;
    }
    public static TradeState getTradeStateByDesc(String desc) {
        for(TradeState tradeState : TradeState.values()) {
            if(tradeState.getDesc().equals(desc)) {
                return tradeState;
            }
        }
        return null;
    }

}
