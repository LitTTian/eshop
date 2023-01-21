package com.lrz.eshop.controller;

import com.google.code.kaptcha.Producer;
import com.lrz.eshop.common.captchaapi.CaptchaExpiration;
import com.lrz.eshop.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 图片验证码控制类
 * @author 天天
 * @create 2023/1/21 14:34
 * @description
 */
@RestController
@RequestMapping("/api/v1/captcha")
public class CaptchaController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Producer captcharProducer;


    /**
     * 随机生成一个六位图片验证码
     * @param request
     * @param response
     */
    @GetMapping("/getImage")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
        String captchaText = captcharProducer.createText();
        String key = RedisUtils.getRedisKey(request, "captcha");
        // 10分钟过期
        redisTemplate.opsForValue().set(
                key,
                captchaText,
                CaptchaExpiration.ImageCode.getCount(),
                CaptchaExpiration.ImageCode.getTimeUnit()
        );

        BufferedImage bufferedImage = captcharProducer.createImage(captchaText);
        ServletOutputStream outputStream = null;
        try{
            outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* private String getCaptchaKey(@RequestBody HttpServletRequest request){
        String ip = NetworkUtils.getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");
        String key = "user-service:captcha:" + Encrypt.encodeWithSha1(ip + userAgent);
        return key;
    } */



}
