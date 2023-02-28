package com.lrz.eshop;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @ContextConfiguration(locations= {"classpath:application.yml"})
class EshopApplicationTests {

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @Test
    void contextLoads() {
    }

    @Test
    public void test01() {


        String test = jasyptStringEncryptor.encrypt("oss-cn-hangzhou.aliyuncs.com");
        System.out.println("test::" + test);


        // String name = stringEncryptor.encrypt("root");
        // String password = stringEncryptor.encrypt("liruizhi");
        // String url = stringEncryptor.encrypt("jdbc:mysql://43.143.215.47:3306/eshop?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false");
        // //将加密的文本写到配置文件中
        // System.out.println("name=" + name);
        // System.out.println("password=" + password);
        // System.out.println("url=" + url);
        //
        // String name1 = "yWRWzi8K+TM1iHIZYrqspQ==";
        // String password1 = "T4t2tW8gpY6oHKdDeQ5xvKA30mEVw2og";
        // String url1 = "5spTxc59d5YHlqCsa3HKupJbbHj09YpxHjjPeBR+/18jHio6pFPnn56WKRKC8rV1hOsXQHgY8fmECyAjmLOi1kep6QWkrcHHYw/lYePwp4ou2WEeDnD9VkZLSPrwjht4HdeCtA4Blaa6WB1Vd5nfM61vaW/R46xbVicMlZn89BVVoH4D7au5jWcqHPfHiG/g";
        //
        // System.out.println("name1=" + stringEncryptor.decrypt(name1));
        // System.out.println("password1=" + stringEncryptor.decrypt(password1));
        // System.out.println("url1=" + stringEncryptor.decrypt(url1));


    }









}
