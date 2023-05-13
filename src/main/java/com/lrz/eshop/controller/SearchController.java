package com.lrz.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.lrz.eshop.common.page.MyPageInfo;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * 商品查询控制类
 * @author 天天
 * @create 2023/3/3 14:21
 * @description
 */
@Api(tags = "search-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    private int PAGE_SIZE = 20;


    @ApiOperation("根据页码、大小关键字查询有序model")
    @GetMapping("/model")
    public Result<?> search(
            @RequestParam(required = false, defaultValue = "") String keyword,
            @RequestParam(required = false, defaultValue = "1") int page) throws IOException {
        int from = (page - 1) * PAGE_SIZE;
        MyPageInfo<ModelMapping> pageInfo = searchService.search(keyword, from, PAGE_SIZE);
        return Result.success(pageInfo);
    }


    @ApiOperation("根据页码、大小关键字查询有序model")
    @GetMapping("/{page}/{keyword}/{order}")
    public Result<?> findPageByKeywordOrder(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "order") String order,
                                       @PathVariable(value = "keyword") String keyword) {
        PageInfo<Model> pageInfo = searchService.findPageByKeywordOrder(page, PAGE_SIZE, keyword, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码、关键字查询model")
    @GetMapping("/{page}/{keyword}")
    public Result<?> findPageByKeyword(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "keyword") String keyword) {
        PageInfo<Model> pageInfo = searchService.findPageByKeyword(page, PAGE_SIZE, keyword);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据类别，页面大小查询model")
    @GetMapping("/category/{page}/{categoryId}/{order}")
    public Result<?> findPageByCategoryIdOrder(@PathVariable(value = "page") Integer page,
                                          @PathVariable(value = "categoryId") String categoryId,
                                          @PathVariable(value = "order") String order) {
        PageInfo<Model> pageInfo = searchService.findPageByCategoryIdOrder(page, PAGE_SIZE, categoryId, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码、大小关键字查询有序model")
    @GetMapping("/article/{page}/{keyword}/{order}")
    public Result<?> findPageArticleByKeywordOrder(@PathVariable(value = "page") Integer page,
                                            @PathVariable(value = "order") String order,
                                            @PathVariable(value = "keyword") String keyword) {
        PageInfo<ArticleShowInfo> pageInfo = searchService.findPageArticleByKeywordOrder(page, PAGE_SIZE, keyword, order);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据页码、关键字查询model")
    @GetMapping("/article/{page}/{keyword}")
    public Result<?> findPageArticleByKeyword(@PathVariable(value = "page") Integer page,
                                       @PathVariable(value = "keyword") String keyword) {
        PageInfo<ArticleShowInfo> pageInfo = searchService.findPageArticleByKeywordOrder(page, PAGE_SIZE, keyword, "watches desc");
        return Result.success(pageInfo);
    }

    @ApiOperation("根据类别，页面大小查询model")
    @GetMapping("/article/category/{page}/{categoryId}/{order}")
    public Result<?> findPageArticleByCategoryIdOrder(@PathVariable(value = "page") Integer page,
                                               @PathVariable(value = "categoryId") String categoryId,
                                               @PathVariable(value = "order") String order) {
        PageInfo<ArticleShowInfo> pageInfo = searchService.findPageArticleByCategoryIdOrder(page, PAGE_SIZE, categoryId, order);
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
