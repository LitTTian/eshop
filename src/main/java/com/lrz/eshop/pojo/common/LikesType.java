package com.lrz.eshop.pojo.common;

/**
 * @author 天天
 * @create 2023/4/24 1:09
 * @description
 */
public enum LikesType {
    ARTICLE(1, "文章"),
    COMMENT(2, "主评论"),
    COMMENT_CHILD(3, "子评论");

    private byte code;
    private String name;

    LikesType(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    LikesType(int code, String name) {
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
