package com.lrz.eshop.pojo.common;

/**
 * @author 天天
 * @create 2023/4/24 1:12
 * @description
 */
public enum LikesState {
    CANCEL_LIKES(0, "取消点赞"),
    LIKES(1, "点赞"),
    DISLIKE(2, "踩");

    private byte code;
    private String name;

    LikesState(byte code, String name) {
        this.code = code;
        this.name = name;
    }

    LikesState(int code, String name) {
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
