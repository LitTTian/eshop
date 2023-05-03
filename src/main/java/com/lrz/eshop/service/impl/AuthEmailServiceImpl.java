package com.lrz.eshop.service.impl;

import com.google.code.kaptcha.Producer;
import com.lrz.eshop.common.captcha.CaptchaExpiration;
import com.lrz.eshop.service.AuthEmailService;
import com.lrz.eshop.service.EmailService;
import com.lrz.eshop.service.UserService;
import com.lrz.eshop.controller.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Collections;

/**
 * 验证邮箱服务
 * @author 天天
 * @create 2023/1/21 2:08
 * @description
 */

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AuthEmailServiceImpl implements AuthEmailService {

    // 验证码有效期：expiration秒

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Producer captcharProducer;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Override
    public Boolean sendEmailCode(String redisKey, String email) {
        String emailCode = (String) redisTemplate.opsForValue().get(redisKey);
        // System.out.println("code = " + code);
        if(!StringUtils.isEmpty(emailCode)) {
            // redis中已经有验证码了，直接返回
            return true;
        }
        // 如果从redis获取不到，
        // 生成验证码，
        emailCode = captcharProducer.createText();
        emailService.sendRegistryCode(
                new EmailDto(Collections.singletonList(email),
                        "验证码",
                        emailCode,
                        "邮箱注册"
                )
        );
        //生成验证码放到redis里面，设置有效时间
        redisTemplate.opsForValue().set(
                redisKey,
                emailCode,
                CaptchaExpiration.MAIL_REGISTRY_CODE.getCount(),
                CaptchaExpiration.MAIL_REGISTRY_CODE.getTimeUnit()
        );
        return true;
    }

    @Override
    public Boolean verifyEmailCode(String redisKey, String code) {
        String emailCode = (String) redisTemplate.opsForValue().get(redisKey);
        return emailCode != null && emailCode.equals(code);
    }


}
