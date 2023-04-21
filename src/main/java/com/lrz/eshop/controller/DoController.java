package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.service.DoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 天天
 * @create 2023/4/19 14:23
 * @description
 */
@Api(tags = "do-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/do")
public class DoController {

    @Autowired
    DoService doService;

    @ApiOperation("根据articleId删除文章")
    @PostMapping("removeArticle")
    public Result<?> removeArticle(@RequestParam(value = "id") String articleId, HttpSession session) {
        String userId = session.getAttribute("id").toString();
        System.out.println("userId: " + userId);
        if(userId == null || articleId == null) {
            return Result.operateFailed();
        }
        Article articleDB = doService.removeArticle(userId, articleId);
        return Result.success("删除成功");
    }

}
