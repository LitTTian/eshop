package com.lrz.eshop.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 编码字符串
 * @author 天天
 * @create 2023/4/13 22:07
 * @description
 */
public class Encode {


    /**
     * 将base64转换成十进制数（一个字符转换为2位数）
     * @param str
     */
    public static String encodeToNumber(String str) {
        StringBuilder newstr = new StringBuilder();
        for(int i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            int index = (int) c;
            // System.out.print(c);
            if(index >= 97) { // a-z
                newstr.append(index - 71);
            }else if(index >= 75) { // K-Z
                newstr.append(index - 65);
            }else if (index >= 65) { // A-J
                newstr.append("0").append(index - 65);
                // newstr.append(index - 65);
            }else if(index >= 48 && index <= 57) { // 0-9
                newstr.append(index + 4);
            }else if(index == 43) {
                newstr.append(62);
            }else if (index == 47) {
                newstr.append(63);
            }else if (index == 61) {
                newstr.append(64);
            }else {
                System.out.println(c);
                System.out.println(index);
                System.out.println("错误");
            }
        }
        System.out.println();
        return newstr.toString();
    }

    /**
     * 将十进制数转换成base64
     * @param str
     * @return
     */
    public static String decodeToBase64(String str) {
        // System.out.println(str);
        // System.out.println(str.length());
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};
        StringBuilder newstr = new StringBuilder();
        if(str.length() % 8 != 0) {
            System.out.println("错误");
            return null;
        }
        for(int i = 0; i < str.length(); i += 2) {
            int index = Integer.parseInt(str.substring(i, i + 2));
            // System.out.println(index);
            newstr.append(ch[index]);
        }
        return newstr.toString();
    }


    /**
     * 将字符串8位为一组返回long数组
     * @param str 数字字符串
     */
    public static long[] group(String str) {
        if(str.length() % 8 != 0) {
            System.out.println("错误");
        }
        int length = str.length() / 8;
        long[] arr = new long[length];
        for(int i = 0; i < length; i ++) { // 8位为一组
            arr[i] = Long.parseLong(str.substring(i * 8, i * 8 + 8));
        }
        return arr;
    }

    /**
     * 将long数组合并成字符串
     * @param arr 数字数组
     * @return
     */
    public static String merge(long[] arr) {
        StringBuilder newstr = new StringBuilder();
        for(long l : arr) {
            if(String.valueOf(l).length() < 8) {
                for(int i = 0; i < 8 - String.valueOf(l).length(); i ++) {
                    newstr.append("0");
                }
            }
            newstr.append(l);
        }
        return newstr.toString();
    }


    public static long[] encodeAndGroup(String str) {
        String base64Str = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        // System.out.println(base64Str);
        // System.out.println(base64Str.length());
        String code = encodeToNumber(base64Str);
        // System.out.println(code);
        long[] arr = group(code);
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static String mergeAndDecode(long[] arr) {
        String mergeStr = merge(arr);
        String decodeStr = decodeToBase64(mergeStr);
        // System.out.println(decodeStr);
        return new String(Base64.getDecoder().decode(decodeStr));
    }

}
