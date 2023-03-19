package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.article.*;
import com.lrz.eshop.pojo.article.*;
import com.lrz.eshop.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天天
 * @create 2023/3/15 17:49
 * @description
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleTagMapper articleTagMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    ArticleCommentMapper articleCommentMapper;
    @Autowired
    ArticleCommentChildMapper articleCommentChildMapper;

    @Override
    public Article getArticleById(String articleId) {
        Article article = articleMapper.selectDetailInfoById(articleId);
        if (article == null) {
            return null;
        }
        article.setWatches(article.getWatches() + 1);
        articleMapper.updateById(article);
        return article;
    }

    @Override
    public Article addArticle(Article article) {
        return articleMapper.insert(article) == 1 ? article : null;
    }

    @Override
    public ArticleTag addArticleTag(ArticleTag articleTag) {
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", articleTag.getName());
        Tag tag = tagMapper.selectOne(queryWrapper);
        if(tag == null) {
            tag = new Tag();
            tag.setName(articleTag.getName());
            tagMapper.insert(tag);
        }
        articleTag.setTagId(tag.getId());
        articleTag.setSeq(currentSeq(String.valueOf(articleTag.getArticleId())));
        return articleTagMapper.insert(articleTag) == 1 ? articleTag : null;
    }
    public int currentSeq(String articleId) { // 计算tag的seq
        Integer seq = articleTagMapper.maxSeq(articleId);
        return seq == null ? 1 : seq + 1;
    }

    @Override
    public ArticleComment addArticleComment(ArticleComment articleComment) {
        return articleCommentMapper.insert(articleComment) == 1 ? articleCommentMapper.selectDetailById(String.valueOf(articleComment.getId())) : null;
    }

    @Override
    public ArticleCommentChild addArticleCommentChild(ArticleCommentChild articleCommentChild) {
        return articleCommentChildMapper.insert(articleCommentChild) == 1 ? articleCommentChildMapper.selectDetailById(String.valueOf(articleCommentChild.getId())) : null;
    }




}
