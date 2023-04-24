package com.lrz.eshop.pojo.common;

import lombok.Data;

/**
 * @author 天天
 * @create 2023/4/22 11:35
 * @description
 */
public enum StarType {
    ARTICLE(1, "文章"),
    PRODUCT(2, "商品"),
    USER(3, "用户");

    private byte code;
    private String name;

    StarType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    StarType(int code, String name) {
        this.code = (byte) code;
        this.name = name;
    }

    public byte getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
