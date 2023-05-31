package com.lrz.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.lrz.eshop.common.page.MyPageInfo;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.elasticsearch.ArticleMapping;
import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 查询控制类
 * @author 天天
 * @create 2023/3/3 14:21
 * @description
 */
@Api(tags = "search-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/search")
@Slf4j
public class SearchController {

    @Autowired
    private SearchService searchService;

    private int PAGE_SIZE_MODEL = 20;
    private int PAGE_SIZE_ARTICLE = 5;

    private int PAGE_SIZE_USERPAGE = 6;


    // ElasticSearch
    @ApiOperation("根据关键字查询model")
    @GetMapping("/model")
    public Result<?> searchModel(
            @RequestParam(required = false, defaultValue = "") String keyword,
            @RequestParam(required = false, defaultValue = "1") int page) throws IOException {
        log.info("按关键字查询商品：keyword: " + keyword + " page: " + page);
        int from = (page - 1) * PAGE_SIZE_MODEL;
        MyPageInfo<ModelMapping> pageInfo = searchService.search(keyword, from, PAGE_SIZE_MODEL);
        return Result.success(pageInfo);
    }
    @ApiOperation("根据类别id查询有序model")
    @GetMapping("/model/category")
    public Result<?> searchModelCategory(
            @RequestParam(required = false, defaultValue = "", value = "categoryId") String categoryId,
            @RequestParam(required = false, defaultValue = "1", value = "page") int page,
            @RequestParam(required = false, defaultValue = "create_time", value = "order") String order) throws IOException {
        log.info("按类别查询商品：categoryId: " + categoryId + " page: " + page + " order: " + order);
        int from = (page - 1) * PAGE_SIZE_MODEL;
        MyPageInfo<ModelMapping> pageInfo = searchService.searchByCategoryIdOrder(categoryId, order, from, PAGE_SIZE_MODEL);
        return Result.success(pageInfo);
    }

    @ApiOperation("最新的4个model")
    @GetMapping("/model/new")
    public Result<?> searchModelNew() throws IOException {
        log.info("最新的4个model");
        MyPageInfo<ModelMapping> pageInfo = searchService.searchModelNew(4);
        return Result.success(pageInfo);
    }

    @ApiOperation("销售量最多的4个model")
    @GetMapping("/model/hot")
    public Result<?> searchModelHot() throws IOException {
        log.info("销售量最多的4个model");
        MyPageInfo<ModelMapping> pageInfo = searchService.searchModelHot(4);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据关键字查询article")
    @GetMapping("/article")
    public Result<?> searchArticle(
            @RequestParam(required = false, defaultValue = "") String keyword,
            @RequestParam(required = false, defaultValue = "1") int page) throws IOException {
        log.info("按关键字查询文章：keyword: " + keyword + " page: " + page);
        int from = (page - 1) * PAGE_SIZE_ARTICLE;
        MyPageInfo<ArticleMapping> pageInfo = searchService.searchArticle(keyword, from, PAGE_SIZE_ARTICLE);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据类别id查询有序article")
    @GetMapping("/article/category")
    public Result<?> searchArticleCategory(
            @RequestParam(required = false, defaultValue = "", value = "categoryId") String categoryId,
            @RequestParam(required = false, defaultValue = "1", value = "page") int page,
            @RequestParam(required = false, defaultValue = "create_time", value = "order") String order) throws IOException {
        log.info("按类别查询文章：categoryId: " + categoryId + " page: " + page + " order: " + order);
        int from = (page - 1) * PAGE_SIZE_ARTICLE;
        MyPageInfo<ArticleMapping> pageInfo = searchService.searchArticleByCategoryIdOrder(categoryId, order, from, PAGE_SIZE_ARTICLE);
        return Result.success(pageInfo);
    }

    @ApiOperation("最热门的6个article")
    @GetMapping("/article/hot")
    public Result<?> searchHotArticle() throws IOException {
        log.info("最热门文章");
        MyPageInfo<ArticleMapping> pageInfo = searchService.searchHotArticle(PAGE_SIZE_ARTICLE);
        return Result.success(pageInfo);
    }





    // 普通search
    @ApiOperation("根据页码、大小关键字查询有序model")
    @GetMapping("/{page}/{keyword}/{order}")
    public Result<?> findPageByKeywordOrder(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "order") String order,
                                       @PathVariable(value = "keyword") String keyword) {
        PageInfo<Model> pageInfo = searchService.findPageByKeywordOrder(page, PAGE_SIZE_MODEL, keyword, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码、关键字查询model")
    @GetMapping("/{page}/{keyword}")
    public Result<?> findPageByKeyword(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "keyword") String keyword) {
        PageInfo<Model> pageInfo = searchService.findPageByKeyword(page, PAGE_SIZE_MODEL, keyword);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据类别，页面大小查询model")
    @GetMapping("/category/{page}/{categoryId}/{order}")
    public Result<?> findPageByCategoryIdOrder(@PathVariable(value = "page") Integer page,
                                          @PathVariable(value = "categoryId") String categoryId,
                                          @PathVariable(value = "order") String order) {
        PageInfo<Model> pageInfo = searchService.findPageByCategoryIdOrder(page, PAGE_SIZE_MODEL, categoryId, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码、大小关键字查询有序model")
    @GetMapping("/article/{page}/{keyword}/{order}")
    public Result<?> findPageArticleByKeywordOrder(@PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "order") String order,
                                            @PathVariable(value = "keyword") String keyword) {
        PageInfo<ArticleShowInfo> pageInfo = searchService.findPageArticleByKeywordOrder(page, PAGE_SIZE_MODEL, keyword, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码、关键字查询model")
    @GetMapping("/article/{page}/{keyword}")
    public Result<?> findPageArticleByKeyword(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "keyword") String keyword) {
        PageInfo<ArticleShowInfo> pageInfo = searchService.findPageArticleByKeywordOrder(page, PAGE_SIZE_MODEL, keyword, "watches desc");
        return Result.success(pageInfo);
    }

    @ApiOperation("根据类别，页面大小查询model")
    @GetMapping("/article/category/{page}/{categoryId}/{order}")
    public Result<?> findPageArticleByCategoryIdOrder(@PathVariable(value = "page") Integer page,
                                               @PathVariable(value = "categoryId") String categoryId,
                                               @PathVariable(value = "order") String order) {
        PageInfo<ArticleShowInfo> pageInfo = searchService.findPageArticleByCategoryIdOrder(page, PAGE_SIZE_MODEL, categoryId, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码，页面大小查询model")
    @GetMapping("/test/{page}/{keyword}/{order}/{size}")
    public Result<?> findPageByKeyword(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "keyword") String keyword,
                                       @PathVariable(value = "order") String order,
                                       @PathVariable(value = "size") Integer size){
        PageInfo<Model> pageInfo = searchService.findPageByKeywordOrder(page, size, keyword, order);
        return Result.success(pageInfo);
    }





}
