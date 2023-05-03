package com.lrz.eshop.component;

import lombok.Data;

@Data
public class ReceiveMessage { // 定义websocket收到的消息

    private String roomId;
    // 接收者userId
    private String toId;
    // 发送者userId
    private String userId;
    private String content;

    private Integer type;

}
