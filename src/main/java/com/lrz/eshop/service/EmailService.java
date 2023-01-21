package com.lrz.eshop.service;

import com.lrz.eshop.service.dto.EmailDto;

/**
 *
 * @author 天天
 * @create 2023/1/21 1:07
 * @description
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param emailDto 邮箱列表
     */
    void sendRegistryCode(EmailDto emailDto);
}
