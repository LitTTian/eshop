package com.lrz.eshop.pojo;

/**
 * @author 天天
 * @create 2023/4/24 21:03
 * @description
 */
public enum DeletedByte {
    DELETED(1, "已删除"),
    NOT_DELETED(0, "未删除");

    private byte code;
    private String desc;
    DeletedByte(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    DeletedByte(int code, String desc) {
        this.code = (byte) code;
        this.desc = desc;
    }
    public byte getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }
}
