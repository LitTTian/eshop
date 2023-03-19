package com.lrz.eshop.pojo.chat;

import lombok.Data;

@Data
public class ResultMessage {
    private String type;
    // 是否来自于一个新用户
    private boolean fromNew;
    // 唯一标识聊天对象的id，我均采用房间id
    private String id;
    private Object result;
}
