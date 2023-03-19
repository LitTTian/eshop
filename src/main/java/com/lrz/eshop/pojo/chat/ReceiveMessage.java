package com.lrz.eshop.pojo.chat;

import lombok.Data;

@Data
public class ReceiveMessage {

    private String roomId;
    // 接收者userId
    private String toId;
    private String content;
}
