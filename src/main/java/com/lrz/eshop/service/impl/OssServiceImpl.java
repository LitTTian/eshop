package com.lrz.eshop.service.impl;

import com.aliyun.oss.OSSClient;
import com.lrz.eshop.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.lrz.eshop.util.ImageNameUtil;

import java.io.IOException;
import java.io.InputStream;



/**
 * OSS存储服务
 * @author 天天
 * @create 2023/1/19 5:17
 * @description
 */
@Service
public class OssServiceImpl implements OssService {

    @Value("${aliyun.oss.bucket-name}")
    private String ossBucketName;

    @Value("${aliyun.oss.dir-prefix}")
    private String ossDirPrefix;

    @Autowired
    private OSSClient ossClient;

    @Override
    public String uploadFileAvatar(MultipartFile file, String uid) {
        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // images/users/123456/avatar/2021/01/19/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        String filepath = ossDirPrefix + "users/" + uid + "/avatar/" + ImageNameUtil.getImgName(file.getOriginalFilename());
        // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
        ossClient.putObject(ossBucketName, filepath, inputStream);
        // https://oss-cn-hangzhou.aliyuncs.com/images/users/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        String url = "https://" + ossClient.getEndpoint().getHost() + "/" + filepath;
        return url;
    }
}
