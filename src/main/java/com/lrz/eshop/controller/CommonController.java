package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.*;
import com.lrz.eshop.pojo.article.Tag;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.service.CommonService;
import com.lrz.eshop.service.LikeService;
import com.lrz.eshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/27 14:05
 * @description
 */
@Api(tags = "common-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @Autowired
    LikeService likeService;

    @Autowired
    UserService userService;


    @ApiOperation("上传轮播图")
    @PostMapping("/uploadBannerImage")
    public Result<?> uploadBannerImage(@RequestParam("file") MultipartFile file, @RequestParam("foreignId") String foreignId, @RequestParam("type") byte type) {
        Banner banner = new Banner();
        banner.setForeignId(Long.valueOf(foreignId));
        banner.setType(type);
        String url = commonService.uploadBannerImage(file, foreignId, type);
        if(url == null) {
            return Result.operateFailed();
        }
        banner.setImgUrl(url);
        commonService.insertBanner(banner);
        return Result.success("更新成功", banner);
    }


    // 商城
    @ApiOperation("获取首页轮播图")
    @GetMapping("/banner")
    public Result<?> getAllHomeBanner() {
        return Result.success("获取成功", commonService.getAllHomeBanner());
    }

    @ApiOperation("获取分类弹出层")
    @GetMapping("/queryTop")
    public Result<?> queryTop() {
        List<Category> categories = commonService.selectAllCategoryWithTopModel();
        if(categories == null) {
            return Result.operateFailed();
        }
        return Result.success("获取成功", categories);
    }

    @ApiOperation("获取热门文章标签")
    @GetMapping("/hotTags")
    public Result<?> hotTags() {
        List<Tag> tags = commonService.hotTags();
        if(tags == null) return Result.operateFailed();
        return Result.success("获取热门文章标签成功", tags);
    }


    // 获取文章展示卡片
    @ApiOperation("获取文章卡片：根据关键字")
    @GetMapping("/getMostWatchesArticleCard/{keyword}/{key}")
    public Result<?> selectMostWatchesArticleCardByCategoryId(
            @PathVariable(value = "keyword") String keyword,
            @PathVariable(value = "key") String key) {
        List<ArticleShowInfo> list = commonService.selectMostWatchesArticleCardByKeyword(keyword, key);
        if(list == null) {
            return Result.operateFailed();
        }
        return Result.success("获取成功", list);
    }


    @ApiOperation("获取文章首页展示卡片")
    @GetMapping("/getMostWatchesArticleCard")
    public Result<?> selectMostLikesArticleCard() {
        List<ArticleShowInfo> list = commonService.selectMostWatchesArticleCard();
        if(list == null) {
            return Result.operateFailed();
        }
        return Result.success("获取成功", list);
    }

}
