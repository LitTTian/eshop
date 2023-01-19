package com.lrz.eshop.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    /**  
     * 上传头像到阿里云OSS
     * @author 天天
     * @create 2023/1/19 17:21  
     * @description
     */
    String uploadFileAvatar(MultipartFile file, String path);
}
