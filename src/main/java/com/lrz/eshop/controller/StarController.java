package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.Likes;
import com.lrz.eshop.pojo.common.LikesState;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.common.StarType;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.ModelCardInfo;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import com.lrz.eshop.service.ArticleService;
import com.lrz.eshop.service.StarService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 收藏控制类
 * @author 天天
 * @create 2023/4/22 2:15
 * @description
 */

@Api(tags = "star-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/star")
public class StarController {

    @Autowired
    private StarService starService;


    // 三种收藏的id信息
    @PostMapping("/selectCollectUserId")
    public Result<?> selectCollectUserId(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        List<String> ids = starService.selectCollectId(userId, StarType.USER);
        return Result.success("查询成功", ids);
    }
    @PostMapping("/selectCollectModelId")
    public Result<?> selectCollectModelId(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        List<String> ids = starService.selectCollectId(userId, StarType.PRODUCT);
        return Result.success("查询成功", ids);
    }
    @PostMapping("/selectCollectArticleId")
    public Result<?> selectCollectArticleId(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        List<String> ids = starService.selectCollectId(userId, StarType.ARTICLE);
        return Result.success("查询成功", ids);
    }

    // 三种收藏的具体展示信息
    @ApiOperation("根据userId获取用户关注的用户信息")
    @PostMapping("/selectCollectUser")
    public Result<?> selectCollectUser(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        List<UserSocialInfo> users = starService.selectCollectUsersByUserId(userId);
        return Result.success("查询成功", users);
    }

    @ApiOperation("根据userId获取用户收藏的商品")
    @PostMapping("/selectCollectModel")
    public Result<?> selectCollectModel(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        List<ModelCardInfo> models = starService.selectCollectModelByUserId(userId);
        return Result.success("查询成功", models);
    }

    // selectCollectArticle
    @ApiOperation("根据userId获取用户收藏的文章")
    @PostMapping("/selectCollectArticle")
    public Result<?> selectCollectArticle(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        List<ArticleShowInfo> models = starService.selectCollectArticleByUserId(userId);
        return Result.success("查询成功", models);
    }


    // 三个收藏方法
    @ApiOperation("收藏用户")
    @PostMapping("/collectUser")
    public Result<?> collectUser(@RequestParam(value = "foreignId") String foreignId, HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        Star star = starService.collectUser(userId, foreignId);
        return Result.success("关注成功", star);
    }

    @ApiOperation("收藏商品")
    @PostMapping("/collectModel")
    public Result<?> collectModel(@RequestParam(value = "foreignId") String foreignId, HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        Star star = starService.collectModel(userId, foreignId);
        return Result.success("关注成功", star);
    }

    @ApiOperation("收藏文章")
    @PostMapping("/collectArticle")
    public Result<?> collectArticle(@RequestParam(value = "foreignId") String foreignId, HttpSession session) {
        String userId = session.getAttribute("id").toString();
        if(userId == null) {
            return Result.operateFailed();
        }
        Star star = starService.collectArticle(userId, foreignId);
        return Result.success("关注成功", star);
    }


    // 喜欢Like
/*     @ApiOperation("收藏")
    @PostMapping("/star")
    // public Result<?> star(@RequestParam("userId") String userId, @RequestParam("modelId") String modelId) {
    public Result<?> star(@RequestBody Star star) {
        if(star.getUserId() == null || star.getForeignId() == null) {
            return Result.operateFailed();
        }
        Star st = commonService.star(star);
        if(st == null) {
            return Result.success("已取消收藏", null);
        }
        return Result.success("收藏成功", st);
    } */

    @ApiOperation("是否已经收藏")
    @PostMapping("/isStared")
    // public Result<?> star(@RequestParam("userId") String userId, @RequestParam("modelId") String modelId) {
    public Result<?> isStared(@RequestBody Star star) {
        if(star.getUserId() == null || star.getForeignId() == null) {
            return Result.operateFailed();
        }
        Boolean isStared = starService.isStared(star);
        if (!isStared) {
            return Result.success("未收藏", false);
        }
        return Result.success("已收藏", true);
    }

    @PostMapping("/like")
    // 必须包含：用户userId，评论/文章foreignId，点赞类型type
    public Result<?> like(@RequestBody Likes like) {
        Likes likeDB = starService.like(like);
        if(likeDB == null) {
            return Result.success("已取消", null);
        } else {
            if(likeDB.getIsLike() == LikesState.LIKES.getCode()) {
                return Result.success("点赞成功", likeDB);
            }else if(likeDB.getIsLike() == LikesState.DISLIKE.getCode()) {
                return Result.success("踩成功", likeDB);
            }else if(likeDB.getIsLike() == LikesState.CANCEL_LIKES.getCode()) {
                return Result.success("取消成功", likeDB);
            }
            return Result.success("操作成功", likeDB);
        }
    }


    @PostMapping("/isLiked")
    // 必须包含：用户userId，评论/文章foreignId，点赞类型type
    public Result<?> isLiked(@RequestBody Likes like) {
        byte isLiked = starService.isLiked(like);
        if(isLiked == LikesState.LIKES.getCode()) {
            return Result.success("已点赞", 1);
        }else if(isLiked == LikesState.DISLIKE.getCode()) {
            return Result.success("已踩", 2);
        }
        return Result.success("未操作", 0);
    }

    @Autowired
    LikeMapper likeMapper;

    @ApiOperation("查询用户的主评论点赞")
    @PostMapping("/selectLikeCommentId")
    // public Result< ? > selectLikeCommentIdsByUserId(@RequestParam("userId") String userId) {
    public Result< ? > selectLikeCommentId(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        List<String> list = likeMapper.selectLikeCommentIdsByUserId(userId);
        return Result.success("查询成功", list);
    }

    @ApiOperation("查询用户的子评论点赞")
    @PostMapping("/selectLikeCommentChildId")
    public Result< ? > selectLikeCommentChildId(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        List<String> list = likeMapper.selectLikeCommentChildIdsByUserId(userId);
        return Result.success("查询成功", list);
    }

    @ApiOperation("查询用户的文章点赞")
    @PostMapping("/selectArticleLike")
    public Result< ? > selectArticleLike(HttpSession session) {
        String userId = session.getAttribute("id").toString();
        List<Likes> list = likeMapper.selectLikeArticleByUserId(userId);
        return Result.success("查询成功", list);
    }



}
