package com.lrz.eshop.service;

import com.lrz.eshop.pojo.article.Article;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 天天
 * @create 2023/4/19 14:40
 * @description
 */
public interface DoService {

    /**
     * 根据articleId删除文章
     * @param userId
     * @param articleId
     * @return
     */
    Article removeArticle(String userId, String articleId);

    Integer updateUserSignature(String userId, String signature);

    Integer updateUserNickname(String userId, String nickname);

    String setAvatar(String userId, MultipartFile image);


}
