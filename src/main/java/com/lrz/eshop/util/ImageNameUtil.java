package com.lrz.eshop.util;

import java.util.UUID;

/**
 * 图片uuid工具类
 * @author 天天
 * @create 2023/1/19 16:47
 * @description
 */
public class ImageNameUtil {
    private static final String[] imageExtension = {".jpg", ".jpeg", ".png", ".gif"};

    public static String getImgName(String url) {
        String ext = "";
        for (String extItem : imageExtension) {
            if (url.indexOf(extItem) != -1) {
                ext = extItem;
                break;
            }
        }
        // db39a8379db54ae0a92e82f498751589.jpg
        return  UUID.randomUUID().toString().replace("-","") + ext;
    }
}
