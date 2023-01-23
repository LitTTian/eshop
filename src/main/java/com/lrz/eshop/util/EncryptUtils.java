package com.lrz.eshop.util;

import com.lrz.eshop.util.encrypt.AESUtils;
import org.apache.commons.codec.digest.DigestUtils;

/**  
 * 加密工具类
 * @author 天天  
 * @create 2023/1/19 17:21  
 * @description
 */
public class EncryptUtils {

    private final AESUtils aesUtils = new AESUtils();

    /**
     * AES加密
     * @param content
     * @return
     */
    public static String aesEncrypt (String content) {
        return AESUtils.Encrypt(content);
    }

    /**
     * AES解密
     * @param content
     * @return
     */
    public static String aesDecrypt (String content) {
        return AESUtils.Decrypt(content);
    }


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
