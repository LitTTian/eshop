package com.lrz.eshop.service;

import com.lrz.eshop.service.dto.AuthUserDto;

/**
 *
 * @author 天天
 * @create 2023/1/21 2:03
 * @description
 */
public interface AuthEmailService {
    /**
     * 向指定邮箱发送验证码
     *
     * @param email 邮箱号
     * @return 结果
     */
    String sendMailCode(String email);

    /**
     * 注册
     *
     * @param authUserDto 认证用户请求信息
     * @return 是否成功
     */
    String register(AuthUserDto authUserDto);
}
