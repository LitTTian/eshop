package com.lrz.eshop.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {

    /**
     * 根据{path}将{file}上传到oss指定路径
     * @param file
     * @param path
     * @return 成功返回路径
     */
    String uploadFile(MultipartFile file, String path);

    Boolean deleteFile(String path);


    /**  
     * 上传头像到阿里云OSS
     * @author 天天
     * @create 2023/1/19 17:21  
     * @description
     */
    // String uploadFileAvatar(MultipartFile file, String path);

}
