package com.lrz.eshop.pojo.chat;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**  
 * table name:  message
 * @author 天天  
 * @create 2023/1/19 17:17  
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("message")
public class Message {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roomId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    @TableField(exist = false)
    private UserSocialInfo user; // 发送者的信息

    @TableField(exist = false)
    private String content; // 原来的消息内容
    private Short type; // 消息类型
    @TableField(exist = false)
    private List<MessageContent> messageContents; // 加密后的消息内容
    // private boolean seen; // 接受者是否看过了消息
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;

}


