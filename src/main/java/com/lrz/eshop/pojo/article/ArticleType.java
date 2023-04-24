package com.lrz.eshop.pojo.article;

/**
 * @author 天天
 * @create 2023/4/24 1:21
 * @description
 */
public enum ArticleType {
    PUBLIC(1, "公共"),
    PRIVATE(2, "私有"),
    DELETED(3, "已删除");
    private byte code;
    private String desc;

    ArticleType(int code, String desc) {
        this.code = (byte) code;
        this.desc = desc;
    }
    ArticleType(byte code, String desc) {
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
