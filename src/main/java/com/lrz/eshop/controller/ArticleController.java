package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.article.*;
import com.lrz.eshop.service.ArticleService;
import com.lrz.eshop.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 17:47
 * @description
 */
@Api(tags = "article-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 根据文章id获取文章详情
     * 包括文章的内容和评论
     * @param articleId
     * @return
     */
    @ApiOperation("根据文章id获取文章详情,用于文章详情页")
    @GetMapping("/getArticleById/{articleId}")
    public Result<?> getArticleById(@PathVariable(value = "articleId") String articleId) {
        Article article = articleService.getArticleById(articleId);
        if(article == null) return Result.failed();
        return Result.success(article);
    }

    @PostMapping("/addArticle")
    public Result<?> addArticle(@RequestBody Article article) {
        Article articleDB = articleService.addArticle(article);
        if(articleDB == null) return Result.failed();
        return Result.success("添加文章成功", articleDB);
    }

    @PostMapping("/addArticleTag")
    public Result<?> addArticleTag(@RequestBody ArticleTag articleTag) {
        ArticleTag articleTagDB = articleService.addArticleTag(articleTag);
        if(articleTagDB == null) return Result.failed();
        return Result.success("添加文章标签成功", articleTagDB);
    }

    @PostMapping("/addArticleTagList")
    public Result<?> addArticleTagList(@RequestBody List<ArticleTag> articleTagList) {
        List<ArticleTag> articleTagDBs = new ArrayList<>();
        for (ArticleTag articleTag : articleTagList) {
            ArticleTag articleTagDB = articleService.addArticleTag(articleTag);
            if(articleTagDB == null) return Result.failed();
            articleTagDBs.add(articleTagDB);
        }
        return Result.success("添加文章标签数组成功",articleTagDBs);
    }


    // @PostMapping("/addArticleTag")
    // public Result<?> addArticleTag(@RequestParam String articleId, @RequestParam String tagId) {
    //     return Result.success();
    // }

    @ApiOperation("评论文章")
    @PostMapping("/articleComment")
    public Result<?> articleComment(@RequestBody ArticleComment articleComment) {
        ArticleComment articleCommentDB = articleService.addArticleComment(articleComment);
        if(articleCommentDB == null) return Result.failed();
        return Result.success("评论成功", articleCommentDB);
    }

    @ApiOperation("评论子评论")
    @PostMapping("/articleCommentChild")
    public Result<?> articleCommentChild(@RequestBody ArticleCommentChild articleCommentChild) {
        ArticleCommentChild articleCommentChildDB = articleService.addArticleCommentChild(articleCommentChild);
        if(articleCommentChildDB == null) return Result.failed();
        return Result.success("评论成功", articleCommentChildDB);
    }



}
