package com.lrz.eshop.controller;

import com.google.code.kaptcha.Producer;
import com.lrz.eshop.common.captcha.CaptchaExpiration;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.service.AuthEmailService;
import com.lrz.eshop.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证码控制类
 * @author 天天
 * @create 2023/1/21 14:34
 * @description
 */
@RestController
@RequestMapping("/api/captcha")
public class CaptchaController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Producer captcharProducer;

    @Autowired
    private AuthEmailService authEmailService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 随机生成一个六位图片验证码
     * @param request
     * @param response
     */
    @GetMapping("/getImage")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response){
        String captchaText = captcharProducer.createText();
        String key = redisUtils.getRedisKey(request, "captcha");
        // 10分钟过期
        redisTemplate.opsForValue().set(
                key,
                captchaText,
                CaptchaExpiration.IMAGINE_CODE.getCount(),
                CaptchaExpiration.IMAGINE_CODE.getTimeUnit()
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

    @GetMapping("/sendEmailCode/{email}")
    public Result<?> sendEmailCodeWithPath(HttpServletRequest request, HttpServletResponse response, @PathVariable String email) {
        String redisKey = redisUtils.getRedisKey(request, "email-code");
        return Result.success(authEmailService.sendEmailCode(redisKey, email));
    }

    @PostMapping("/sendEmailCode")
    public Result<?> sendEmailCode(HttpServletRequest request, HttpServletResponse response, @RequestParam String email) {
        String redisKey = redisUtils.getRedisKey(request, "email-code");
        return Result.success(authEmailService.sendEmailCode(redisKey, email));
    }

    @PostMapping("/verifyEmailCode")
    public Result<?> verifyEmailCode(HttpServletRequest request, HttpServletResponse response,@RequestParam String emailCode) {
        String redisKey = redisUtils.getRedisKey(request, "email-code");
        return Result.success(authEmailService.verifyEmailCode(redisKey, emailCode));
    }

    /* private String getCaptchaKey(@RequestBody HttpServletRequest request){
        String ip = NetworkUtils.getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");
        String key = "user-service:captcha:" + Encrypt.encodeWithSha1(ip + userAgent);
        return key;
    } */


}
