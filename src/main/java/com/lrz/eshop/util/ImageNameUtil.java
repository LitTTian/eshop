package com.lrz.eshop.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 图片uuid工具类
 * @author 天天
 * @create 2023/1/19 16:47
 * @description
 */
@Component
public class ImageNameUtil {
    private final String[] imageExtension = {".jpg", ".jpeg", ".png", ".gif"};

    public String getImgName(String url) {
        String ext = getImageExtension(url);
        // db39a8379db54ae0a92e82f498751589.jpg
        return  UUID.randomUUID().toString().replace("-","") + ext;
    }

    public String getImageExtension(String url) {
        String ext = "";
        for (String extItem : imageExtension) {
            if (url.contains(extItem)) {
                ext = extItem;
                break;
            }
        }
        return ext;
    }
}
