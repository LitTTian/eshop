package com.lrz.eshop.pojo.chat;

import lombok.Data;

@Data
public class ReceiveMessage {

    private String roomId;
    // 接收者userId
    private String toId;
    // 发送者userId
    private String userId;
    private String content;

}
