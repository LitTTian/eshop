package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.article.Like;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.pojo.common.Star;
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
    public Result<?> uploadBannerImage(@RequestParam("file") MultipartFile file, @RequestParam("foreignId") String foreignId, @RequestParam("type") short type) {
        Banner banner = new Banner();
        banner.setForeignId(Long.valueOf(foreignId));
        banner.setType(type);
        String url = commonService.uploadBannerImage(file, foreignId, type);
        if(url == null) {
            return Result.failed();
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
    @GetMapping("/quertTop")
    public Result<?> quertTop() {
        List<Category> categories = commonService.selectAllCategoryWithTopModel();
        if(categories == null) {
            return Result.failed();
        }
        return Result.success("获取成功", categories);
    }


    // 收藏和点赞
    @ApiOperation("收藏")
    @PostMapping("/star")
    // public Result<?> star(@RequestParam("userId") String userId, @RequestParam("modelId") String modelId) {
    public Result<?> star(@RequestBody Star star) {
        if(star.getUserId() == null || star.getForeignId() == null) {
            return Result.failed();
        }
        Star st = commonService.star(star);
        if(st == null) {
            return Result.success("已取消收藏", null);
        }
        return Result.success("收藏成功", st);
    }

    @ApiOperation("是否已经收藏")
    @PostMapping("/isStared")
    // public Result<?> star(@RequestParam("userId") String userId, @RequestParam("modelId") String modelId) {
    public Result<?> isStared(@RequestBody Star star) {
        if(star.getUserId() == null || star.getForeignId() == null) {
            return Result.failed();
        }
        Boolean isStared = commonService.isStared(star);
        if (!isStared) {
            return Result.success("未收藏", false);
        }
        return Result.success("已收藏", true);
    }

    @PostMapping("/like")
    // 必须包含：用户userId，评论/文章foreignId，点赞类型type
    public Result<?> like(@RequestBody Like like) {
        Like likeDB = commonService.like(like);
        if(likeDB == null) {
            return Result.success("已取消", null);
        } else {
            if(likeDB.getType() == 1) {
                return Result.success("点赞成功", likeDB);
            }else if(likeDB.getType() == 2) {
                return Result.success("踩成功", likeDB);
            }
            return Result.success("操作成功", likeDB);
        }
    }

    @PostMapping("/isLiked")
    // 必须包含：用户userId，评论/文章foreignId，点赞类型type
    public Result<?> isLiked(@RequestBody Like like) {
        Short isLiked = commonService.isLiked(like);
        if(isLiked == 1) {
            return Result.success("已点赞", 1);
        }else if(isLiked == 2) {
            return Result.success("已踩", 2);
        }
        return Result.success("未操作", 0);
    }

    @Autowired
    LikeMapper likeMapper;
    @ApiOperation("查询用户的主评论点赞")
    @PostMapping("/selectLikeCommentIdsByUserId")
    public Result< ? > selectLikeCommentIdsByUserId(@RequestParam("userId") String userId) {
        List<String> list = likeMapper.selectLikeCommentIdsByUserId(userId);
        return Result.success("查询成功", list);
    }

    @ApiOperation("查询用户的子评论点赞")
    @PostMapping("/selectLikeCommentChildIdsByUserId")
    public Result< ? > selectLikeCommentChildIdsByUserId(@RequestParam("userId") String userId) {
        List<String> list = likeMapper.selectLikeCommentChildIdsByUserId(userId);
        return Result.success("查询成功", list);
    }

    @ApiOperation("查询用户的文章点赞")
    @PostMapping("/selectArticleLikesByUserId")
    public Result< ? > selectArticleLikesByUserId(@RequestParam("userId") String userId) {
        List<Like> list = likeMapper.selectLikeArticleByUserId(userId);
        return Result.success("查询成功", list);
    }


    // 获取文章展示卡片
    @ApiOperation("获取文章首页展示卡片")
    @GetMapping("/getMostWatchesArticleCard/{categoryId}")
    public Result<?> selectMostWatchesArticleCardByCategoryId(@PathVariable(value = "categoryId") String categoryId) {
        List<ArticleShowInfo> list = commonService.selectMostWatchesArticleCardByCategoryId(categoryId);
        if(list == null) {
            return Result.failed();
        }
        return Result.success("获取成功", list);
    }

    @ApiOperation("获取文章首页展示卡片")
    @GetMapping("/getMostWatchesArticleCard")
    public Result<?> selectMostLikesArticleCard() {
        List<ArticleShowInfo> list = commonService.selectMostWatchesArticleCard();
        if(list == null) {
            return Result.failed();
        }
        return Result.success("获取成功", list);
    }

}
