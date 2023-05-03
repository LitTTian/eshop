package com.lrz.eshop;

import com.lrz.eshop.mapper.chat.MessageContentMapper;
import com.lrz.eshop.mapper.chat.MessageMapper;
import com.lrz.eshop.mapper.article.ArticleMapper;
import com.lrz.eshop.service.CommonService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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


    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageContentMapper messageContentMapper;


    /**
     * 修改数据库结构，将消息内容加密
     */
    // @Test
    // public void test02() {
    //     List<Message> messages = messageMapper.selectList(null);
    //     System.out.println(messages);
    //     for(Message message: messages) {
    //         List<MessageContent> messageContents = EncryptUtils.encryptMessage(message.getContent(), message.getRoomId());
    //         for(MessageContent messageContent: messageContents) {
    //             messageContent.setMessageId(message.getId());
    //             messageContentMapper.insert(messageContent);
    //         }
    //     }
    // }

    /**
     * 测试解密内容
     */
    // @Test
    // public void getMessage() {
    //     List<Message> messages = messageMapper.selectList(null);
    //     for(Message message: messages) {
    //         List<MessageContent> messageContents = messageContentMapper.selectByMessageId(message.getId());
    //         message.setContent(EncryptUtils.decryptMessage(messageContents, message.getRoomId()));
    //         System.out.println(message);
    //     }
    // }


    /**
     * ==>  Preparing: select * from article where ? = ? order by watches desc limit ?
     * SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@785f047e] was not registered for synchronization because synchronization is not active
     * ==> Parameters: categoryId(String), 1001(String), 10(Integer)
     */

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    CommonService commonService;
    /**
     * 测试动态字段
     */
    @Test
    public void testDynamic() {
        // List<Article> articles = articleMapper.selectList(new QueryWrapper<Article>().eq("category_id", "1001").orderByDesc("watches").last("limit 10"));
        // System.out.println(articles);
        System.out.println(commonService.selectMostWatchesArticleCardByKeyword("category", "1001"));
        // System.out.println(articleMapper.selectList(new QueryWrapper<Article>().eq("category_id", "1001").orderByDesc("watches").last("limit 10")));
    }








}
