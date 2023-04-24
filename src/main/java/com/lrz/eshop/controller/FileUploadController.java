package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传控制类
 * @author 天天
 * @create 2023/2/24 14:36
 * @description
 */
@RequestMapping("/api/upload")
@RestController
public class FileUploadController {
    @Autowired
    private OssService ossService;

    /**
     * 根据{path}将{file}上传到oss指定路径
     * @param file
     * @param path
     * @return 成功返回url路径
     */
    @PostMapping("/fileWithPath")
    public Result<?> setAvatar(@RequestParam("file") MultipartFile file, @RequestParam("path") String path) {
        String url = ossService.uploadFile(file, path);
        if (url == null) {
            return Result.operateFailed();
        }
        System.out.println("url: " + url);
        return Result.success(url);
    }


}
