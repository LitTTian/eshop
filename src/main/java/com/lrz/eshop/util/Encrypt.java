package com.lrz.eshop.util;

import org.apache.commons.codec.digest.DigestUtils;

/**  
 * MD5加密工具类
 * @author 天天  
 * @create 2023/1/19 17:21  
 * @description
 */
public class Encrypt {
    public static String encodeWithSha1 (String pwd) {
        if(pwd == null || pwd.length() == 0){
            return null;
        }else{
            return DigestUtils.sha1Hex(pwd);
        }
    }
}
