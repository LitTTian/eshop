package com.lrz.eshop.util.encrypt;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * Jasyp加密工具类
 * @author 天天
 * @create 2023/1/24 0:05
 * @description
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DesUtil {
    /** 默认key */
    public final static String KEY = "liruizhi";

    /**
     * DES加密
     * @param data 待加密字符串
     * @param key 校验位
     * @return
     */
    public static String encrypt(String data,String key) {
        String encryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("加密错误，错误信息：", e);
        }
        return encryptedData;
    }

    /**
     * DES解密
     * @param cryptData 待解密密文
     * @param key 校验位
     * @return
     */
    public static String decrypt(String cryptData,String key) {
        String decryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(deskey);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, sr);
            // 把字符串解码为字节数组，并解密
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            throw new RuntimeException("解密错误，错误信息：", e);
        }
        return decryptedData;
    }


    public static void main(String[] args) {
        String username = encrypt("root", KEY);
        String password = encrypt("liruizhi", KEY);
        String url = encrypt("jdbc:mysql://43.143.215.47:3306/eshop?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false", KEY);
        //将加密的文本写到配置文件中

        System.out.println("name::"+username);
        System.out.println("password::"+password);
        System.out.println("url::"+url);

        System.out.println("username::"+decrypt("MzjNS6EbloE=",KEY));
        System.out.println("password::"+decrypt(password,KEY));
        System.out.println("url::"+decrypt(url,KEY));

    }

}