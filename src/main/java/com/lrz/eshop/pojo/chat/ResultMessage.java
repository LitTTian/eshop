package com.lrz.eshop.pojo.chat;

import lombok.Data;

@Data
public class ResultMessage {
    private String type;
    // 是否来自于一个新用户
    private boolean fromNew;
    private String fromUsername;
    private Object message;
}
