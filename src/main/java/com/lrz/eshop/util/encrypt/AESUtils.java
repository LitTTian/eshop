package com.lrz.eshop.util.encrypt;

import com.lrz.eshop.util.EncryptUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密工具类
 * @author 天天
 * @create 2023/1/23 12:40
 * @description
 */
public class AESUtils {

    static Logger logger = LoggerFactory.getLogger(EncryptUtils.class);
    // 密钥
    public static String key = "AD42F6697B035B7580E4FEF93BE20BAD";
    private static String charset = "utf-8";
    // 偏移量
    private static int offset = 16;
    // 加密器类型:加密算法为AES,加密模式为CBC,补码方式为PKCS5Padding
    private static String transformation = "AES/CBC/PKCS5Padding";
    // 算法类型：用于指定生成AES的密钥
    private static String algorithm = "AES";


    /**
     * 加密
     *
     * @param content
     * @return
     */
    public static String Encrypt(String content) {
        return Encrypt(content, key);
    }

    /**
     * 解密
     *
     * @param content
     * @return
     */
    public static String Decrypt(String content) {
        return Decrypt(content, key);
    }

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @param key     加密密码
     * @return
     */
    public static String Encrypt(String content, String key) {
        try {
            //构造密钥
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
            //创建初始向量iv用于指定密钥偏移量(可自行指定但必须为128位)，因为AES是分组加密，下一组的iv就用上一组加密的密文来充当
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, offset);
            //创建AES加密器
            Cipher cipher = Cipher.getInstance(transformation);
            byte[] byteContent = content.getBytes(charset);
            //使用加密器的加密模式
            cipher.init(Cipher.ENCRYPT_MODE, skey, iv);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            //使用BASE64对加密后的二进制数组进行编码
            return new Base64().encodeToString(result);
        } catch (Exception e) {
            logger.info("", e);
        }
        return null;
    }

    /**
     * AES（256）解密
     *
     * @param content 待解密内容
     * @param key     解密密钥
     * @return 解密之后
     * @throws Exception
     */
    public static String Decrypt(String content, String key) {
        try {

            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), algorithm);
            IvParameterSpec iv = new IvParameterSpec(key.getBytes(), 0, offset);
            Cipher cipher = Cipher.getInstance(transformation);
            //解密时使用加密器的解密模式
            cipher.init(Cipher.DECRYPT_MODE, skey, iv);// 初始化
            byte[] result = cipher.doFinal(new Base64().decode(content));
            return new String(result); // 解密
        } catch (Exception e) {
            logger.info("", e);
        }
        return null;
    }

    public static void main(String[] args) {
        String content = "Liruizhi.123";
        String encrypt = Encrypt(content);
        System.out.println("加密后：" + encrypt);
        String decrypt = Decrypt(encrypt);
        System.out.println("解密后：" + decrypt);
    }

}
