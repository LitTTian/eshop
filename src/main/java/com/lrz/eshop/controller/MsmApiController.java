package com.lrz.eshop.controller;

import com.alibaba.druid.util.StringUtils;
import com.google.code.kaptcha.Producer;
import com.lrz.eshop.common.captcha.CaptchaExpiration;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.service.EmailService;
import com.lrz.eshop.controller.dto.EmailDto;
import com.lrz.eshop.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

/**
 * 手机|邮件验证码控制类
 * @author 天天
 * @create 2023/1/21 18:57
 * @description
 */
@RestController
@RequestMapping("/api/v0/captcha")
public class MsmApiController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Producer captcharProducer;

    @Autowired
    private EmailService emailService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 发送手机验证码
     * @param phone
     * @return
     */
    /* @GetMapping("send/{phone}")
    public Result<?> sendCode(@PathVariable String phone) {
        // 从redis获取验证码，如果获取获取到，返回ok
        // key 手机号  value 验证码
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)) {
            return Result.success("验证码已发送");
        }
        //如果从redis获取不到，
        // 生成验证码，
        code = RandomUtil.getSixBitRandom();
        //调用service方法，通过整合短信服务进行发送
        if(msmService.send(phone,code)) {
            //生成验证码放到redis里面，设置有效时间
            redisTemplate.opsForValue().set(phone,code,2, TimeUnit.MINUTES);
            return Result.success("成功发送验证码");
        } else {
            return Result.failed("发送短信失败");
        }
    } */
    /**
     * 发送邮件验证码
     * @param email
     * @return
     */
    @GetMapping("/sendEmail/{email}")
    public Result<?> sendEmailCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String email) {
        String redisKey = redisUtils.getRedisKey(request, "email");
        String code = (String) redisTemplate.opsForValue().get(redisKey);
        System.out.println("code = " + code);
        if(!StringUtils.isEmpty(code)) {
            return Result.success("验证码已发送");
        }
        // 如果从redis获取不到，
        // 生成验证码，
        code = captcharProducer.createText();
        emailService.sendRegistryCode(
                new EmailDto(Collections.singletonList(email),
                        "验证码",
                        code,
                        "邮箱注册"));
        //生成验证码放到redis里面，设置有效时间
        redisTemplate.opsForValue().set(
                redisKey,
                code,
                CaptchaExpiration.MAIL_REGISTRY_CODE.getCount(),
                CaptchaExpiration.MAIL_REGISTRY_CODE.getTimeUnit()
        );
        return Result.success("成功发送验证码");
    }
}
