package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.mapper.article.ArticleMapper;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.service.DoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天天
 * @create 2023/4/19 14:40
 * @description
 */
@Service
public class DoServiceImpl implements DoService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public Article removeArticle(String userId, String articleId) {
        Article article = articleMapper.selectById(articleId);
        if(article == null || !String.valueOf(article.getUserId()).equals(userId)) {
            return null;
        }
        article.setType((byte) 3);
        // System.out.println("更新后article: " + article);
        articleMapper.updateById(article);
        return article;
    }

    @Override
    public Integer updateUserSignature(String userId, String signature) {
        User userDB = userMapper.selectById(userId);
        if(userDB == null) {
            return null;
        }
        userDB.setSignature(signature);
        return userMapper.updateById(userDB);
    }

}
