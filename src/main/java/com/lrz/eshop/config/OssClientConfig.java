package com.lrz.eshop.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 根据配置文件自动创建OSSClient对象
 * @author 天天
 * @create 2023/1/19 5:14
 * @description
 */
@Configuration
public class OssClientConfig {
    // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
    @Value("${aliyun.oss.endpoint}")
    String endpoint ;
    // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
    @Value("${aliyun.oss.id}")
    String accessKeyId ;
    @Value("${aliyun.oss.secret}")
    String accessKeySecret;

    @Bean
    public OSSClient createOssClient() {
        // System.out.println("##################endpoint:" + endpoint);
        return (OSSClient)new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}
