package com.lrz.eshop.chat;

import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.Data;

import java.util.Date;

@Data
public class ResultMessage {
    private String type; // 消息类型，暂时用不到
    private boolean fromNew; // 是否是新建立的房间
    private String roomId; // 房间id
    private UserSocialInfo user; // 发送者的信息
    private Date createTime; // 消息创建时间
    private Object result; // 消息内容
}
