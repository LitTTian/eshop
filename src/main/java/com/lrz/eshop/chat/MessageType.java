package com.lrz.eshop.chat;

/**
 * @author 天天
 * @create 2023/4/29 1:06
 * @description
 */


public enum MessageType {
    // 0.登录websocket 1.用户消息 2.群消息 3.群系统消息 4.群用户消息
    VERIFY_TOKEN(0), // 验证token，将token中的userId与websocket session绑定
    USER_MESSAGE(1),
    GROUP_MESSAGE(2),
    GROUP_SYSTEM_MESSAGE(3),
    GROUP_USER_MESSAGE(4);

    private final int type;

    MessageType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
