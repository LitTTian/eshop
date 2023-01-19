package com.lrz.eshop.pojo.chat;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roomId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long fromId;
    private String content;
    private int cnt;
    private boolean specialFormat;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private int version;
    private boolean seen; // 接受者是否看过了消息

    public Message(Long roomId, Long fromId, String content, int cnt, boolean specialFormat){
        this.roomId = roomId;
        this.fromId = fromId;
        this.content = content;
        this.cnt = cnt;
        this.specialFormat = specialFormat;
    }
}
