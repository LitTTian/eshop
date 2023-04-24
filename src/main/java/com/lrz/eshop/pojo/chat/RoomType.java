package com.lrz.eshop.pojo.chat;


/**
 * @author 天天
 * @create 2023/4/24 1:18
 * @description
 */

public enum RoomType {
    SINGLE(1, "私聊"),
    GROUP(2, "群聊");
    private byte code;
    private String desc;

    RoomType(int code, String desc) {
        this.code = (byte) code;
        this.desc = desc;
    }
    RoomType(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
