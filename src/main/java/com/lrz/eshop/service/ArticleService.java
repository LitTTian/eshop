package com.lrz.eshop.service;

import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.pojo.article.ArticleComment;
import com.lrz.eshop.pojo.article.ArticleCommentChild;
import com.lrz.eshop.pojo.article.ArticleTag;
import org.springframework.stereotype.Service;

/**
 * @author 天天
 * @create 2023/3/15 17:49
 * @description
 */
public interface ArticleService {
    Article getArticleById(String articleId);

    Article addArticle(Article article);

    /**
     * 插入articleTag
     * @param articleTag
     * @return
     */
    ArticleTag addArticleTag(ArticleTag articleTag);


    ArticleComment addArticleComment(ArticleComment articleComment);

    ArticleCommentChild addArticleCommentChild(ArticleCommentChild articleCommentChild);
}
