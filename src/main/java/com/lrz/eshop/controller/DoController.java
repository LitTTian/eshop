package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.service.DoService;
import com.lrz.eshop.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

/*    @Autowired
    private HttpSession session;*/

    @Autowired
    private HttpServletRequest request;

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @ApiOperation("根据articleId删除文章")
    @PostMapping("removeArticle")
    public Result<?> removeArticle(@RequestParam(value = "id") String articleId) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        System.out.println("userId: " + userId);
        if(userId == null || articleId == null) {
            return Result.operateFailed();
        }
        Article articleDB = doService.removeArticle(userId, articleId);
        return Result.success("删除成功");
    }

    /**
     * 修改文章签名
     * @param signature
     * @return
     */
    @ApiOperation("修改用户签名")
    @PostMapping("updateUserSignature")
    public Result<?> updateUserSignature(@RequestParam(value = "signature") String signature) {
        // String userId = session.getAttribute("id").toString();
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        if(userId == null || signature == null) {
            return Result.operateFailed();
        }
        Integer count = doService.updateUserSignature(userId, signature);
        if(count == null) {
            return Result.operateFailed();
        }
        return Result.success("修改成功", count);
    }

}
