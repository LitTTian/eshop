package com.lrz.eshop.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 邮件发送信息传输类
 * @author 天天
 * @create 2023/1/21 1:14
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    /**
     * 发送邮箱列表
     */
    private List<String> tos;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;

    /**
     * 类型
     */
    private String type;

}
