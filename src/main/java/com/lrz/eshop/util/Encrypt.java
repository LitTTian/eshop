package com.lrz.eshop.util;

import org.apache.commons.codec.digest.DigestUtils;


public class Encrypt {
    public static String encodeWithSha1 (String pwd) {
        if(pwd == null || pwd.length() == 0){
            return null;
        }else{
            return DigestUtils.sha1Hex(pwd);
        }
    }
}
