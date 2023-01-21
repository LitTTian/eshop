package com.lrz.eshop.util;

import org.apache.commons.codec.digest.DigestUtils;

/**  
 * 加密工具类
 * @author 天天  
 * @create 2023/1/19 17:21  
 * @description
 */
public class Encrypt {

    /**
     * MD5加密
     * @param string 待加密的字符串
     * @return 加密后的字符串
     */
    public static String encodeWithSha1 (String string) {
        if(string == null || string.length() == 0){
            return null;
        }else{
            return DigestUtils.sha1Hex(string);
        }
    }
}
