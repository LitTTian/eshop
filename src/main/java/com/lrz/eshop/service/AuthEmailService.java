package com.lrz.eshop.service;

/**
 *
 * @author 天天
 * @create 2023/1/21 2:03
 * @description
 */
public interface AuthEmailService {
    /**
     * 发送邮箱验证码
     * @param redisKey
     * @param email
     * @return 成功发送true
     */
    public Boolean sendEmailCode(String redisKey, String email);

    /**
     * 验证邮箱验证码
     * @param redisKey
     * @param code
     * @return 验证码相等true
     */
    public Boolean verifyEmailCode(String redisKey, String code);

}
