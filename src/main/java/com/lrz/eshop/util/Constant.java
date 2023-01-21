package com.lrz.eshop.util;

/**
 * 存储了一些常量的工具类
 * @author 天天
 * @create 2023/1/21 11:28
 * @description
 */
public class Constant {
    /**
     * 定义Redis缓存默认过期时间
     */
    public static final int CACHE_TIMEOUT_HOUR=2;


    /**
     * 定义unknown字串串的常量
     */
    public  static final String UNKNOWN = "unknown";

    /**
     * 定义IP地址最大长度
     */
    public static final int IP_MAX_LENGTH = 15;

    /**
     * 定义MB的计算常量
     */
    public static final int MB = 1024 * 1024;
    /**
     * 定义KB的计算常量
     */
    public static final int KB = 1024;

    /**
     * 定义默认验证码属性
     */
    // private int KAPTCHA_TEXTPRODUCER_CHAR_LENGTH;
    // private int KAPTCHA_TEXTPRODUCER_CHAR_SPACE;
    // private String KAPTCHAR_NOISE_IMPL = "";
    // private String KAPTCHA_OBSCURIFICATOR_IMPL = "";
    // private String KAPTCHA_TEXTPRODUCER_CHAR_STRING = "";
}
