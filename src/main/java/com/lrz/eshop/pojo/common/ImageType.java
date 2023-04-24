package com.lrz.eshop.pojo.common;

/**
 * @author 天天
 * @create 2023/4/24 1:14
 * @description
 */
public enum ImageType {
    PRODUCT(1, "商品图片"),
    ARTICLE(4, "文章图片"),
    USER(5, "用户图片");
    private byte code;
    private String name;

    ImageType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    ImageType(int code, String name) {
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
