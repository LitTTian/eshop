package com.lrz.eshop.common.captchaapi;

import java.util.concurrent.TimeUnit;

/**
 * 验证码过期时间
 * @author 天天
 * @create 2023/1/22 1:45
 * @description
 */
public enum CaptchaExpiration {
    MAIL_REGISTRY_CODE(10, TimeUnit.MINUTES, "邮箱注册"),
    IMAGINE_CODE(300, TimeUnit.SECONDS, "图片验证码");
    private int count;
    private TimeUnit timeUnit;

    private String type;


    CaptchaExpiration(int count, TimeUnit timeUnit, String type) {
        this.count = count;
        this.timeUnit = timeUnit;
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public String getType() {
        return type;
    }
}
