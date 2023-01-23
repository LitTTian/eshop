package com.lrz.eshop.util;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * @author 天天
 * @create 2023/1/21 11:33
 * @description
 */
@Component
@AllArgsConstructor
public class RedisUtils {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取验证码key
     * @param request
     * @return
     */
    public static String getRedisKey(@RequestBody HttpServletRequest request, String type){
        String ip = NetworkUtils.getIpAddr(request);
        String userAgent = request.getHeader("User-Agent");
        String key = "user-service:" + type + ":" + EncryptUtils.encodeWithSha1(ip + userAgent);
        return key;
    }

    /**
     * 普通获取键对应值
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通设置键值
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 普通设置键值并设置过期时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @return 是否成功
     */
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 指定缓存的失效时间
     *
     * @param key  键值 @NotNull
     * @param time 时间(秒) @NotNull
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }




}
