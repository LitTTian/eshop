package com.lrz.eshop.service.impl;

import com.lrz.eshop.common.aop.DBLoggerAnnotation;
import com.lrz.eshop.mapper.user.UserMapper;
import com.lrz.eshop.mapper.article.ArticleMapper;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.service.DoService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.util.ImageNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 天天
 * @create 2023/4/19 14:40
 * @description
 */
@Service
public class DoServiceImpl implements DoService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    OssService ossService;

    @Autowired
    ImageNameUtil imageNameUtil;

    @Override
    @DBLoggerAnnotation(module = "文章", operation = "删除文章")
    public Article removeArticle(String userId, String articleId) {
        Article article = articleMapper.selectById(articleId);
        if(article == null || !String.valueOf(article.getUserId()).equals(userId)) {
            return null;
        }
        article.setType((byte) 3);
        // System.out.println("更新后article: " + article);
        articleMapper.updateById(article);
        return article;
    }

    @Override
    @DBLoggerAnnotation(module = "用户", operation = "更新用户签名")
    public Integer updateUserSignature(String userId, String signature) {
        User userDB = userMapper.selectById(userId);
        if(userDB == null) {
            return null;
        }
        userDB.setSignature(signature);
        return userMapper.updateById(userDB);
    }

    @Override
    @DBLoggerAnnotation(module = "用户", operation = "更新用户昵称")
    public Integer updateUserNickname(String userId, String nickname) {
        User userDB = userMapper.selectById(userId);
        if(userDB == null) {
            return null;
        }
        userDB.setNickname(nickname);
        return userMapper.updateById(userDB);
    }

    @Override
    @DBLoggerAnnotation(module = "用户", operation = "设置用户头像")
    public String setAvatar(String userId, MultipartFile image) {
        User userDB = userMapper.selectById(userId);
        if(userDB == null) {
            return null;
        }
        String url = uploadUserAvatar(image, userDB);
        userDB.setAvatarUrl(url);
        userMapper.updateById(userDB);
        return url;
    }

    public String uploadUserAvatar(MultipartFile file, User user) {
        String originPath = user.getAvatarUrl();
        if(originPath != null && !originPath.equals("")) {
            if(!ossService.deleteFile(originPath)) {
                return null;
            }
        }
        // users/123456/avatar/2021/01/19/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        String path = "users/" + user.getId() + "/avatar/" + imageNameUtil.getImgName(file.getOriginalFilename());
        // 成功返回：https://oss-cn-hangzhou.aliyuncs.com/images/users/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        // 否则返回：null
        return ossService.uploadFile(file, path);
    }

}
