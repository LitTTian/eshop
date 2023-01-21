package com.lrz.eshop.common.captchaapi;

import java.util.concurrent.TimeUnit;

/**
 * @author 天天
 * @create 2023/1/22 1:45
 * @description
 */
public enum CaptchaExpiration {
    RegistryCode(10, TimeUnit.MINUTES),
    ImageCode(300, TimeUnit.SECONDS);
    private int count;
    private TimeUnit timeUnit;


    CaptchaExpiration(int count, TimeUnit timeUnit) {
        this.count = count;
        this.timeUnit = timeUnit;
    }

    public int getCount() {
        return count;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
}
