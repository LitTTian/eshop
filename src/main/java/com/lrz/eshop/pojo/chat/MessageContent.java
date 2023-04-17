package com.lrz.eshop.pojo.chat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 加密后的消息内容
 * @author 天天
 * @create 2023/4/13 22:17
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("message_content")
public class MessageContent {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long messageId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long content1;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long content2;
    private int seq;

}
