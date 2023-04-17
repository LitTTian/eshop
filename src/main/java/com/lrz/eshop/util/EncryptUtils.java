package com.lrz.eshop.util;

import com.lrz.eshop.pojo.chat.MessageContent;
import com.lrz.eshop.util.encrypt.AESUtils;
import com.lrz.eshop.util.encrypt.ElgamalUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 使用Elgamal加密
     * @param content 原始消息内容
     * @param roomX 房间的x（房间号）
     * @return 加密后的消息内容<MessageContent>
     */
    public static List<MessageContent> encryptMessage(String content, Long roomX) {
        List<MessageContent> list = new ArrayList<>();
        Long x = Long.parseLong(String.valueOf(roomX));
        long[] arr = Encode.encodeAndGroup(content);
        int i = 0;
        for(long l : arr) {
            long[] arr2 = ElgamalUtils.encrypt(l, x);
            MessageContent msg = new MessageContent();
            msg.setContent1(arr2[0]);
            msg.setContent2(arr2[1]);
            msg.setSeq(i ++);
            list.add(msg);
        }
        return list;
    }

    /**
     * 解密消息内容
     * @param msgs 加密的消息内容
     * @param roomX 房间号
     * @return 解密后的消息内容
     */
    public static String decryptMessage(List<MessageContent> msgs, Long roomX) {
        Long x = Long.parseLong(String.valueOf(roomX));
        long[] longs = new long[msgs.size()];
        int i = 0;
        for(MessageContent msg: msgs) {
            // System.out.println(msg.getC1());
            // System.out.println(msg.getC2());
            long l = ElgamalUtils.decrypt(msg.getContent1(), msg.getContent2(), x);
            longs[i ++] = l;
            // System.out.println(l);
        }
        return Encode.mergeAndDecode(longs);
    }

    public static void main(String[] args) {
        // TEST
    }



}
