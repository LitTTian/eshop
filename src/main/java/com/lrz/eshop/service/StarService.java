package com.lrz.eshop.service;

import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.common.StarType;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.ModelCardInfo;
import com.lrz.eshop.pojo.user.UserSocialInfo;

import java.util.List;

/**
 * @author 天天
 * @create 2023/4/22 2:21
 * @description
 */
public interface StarService {

    List<ArticleShowInfo> selectCollectArticleByUserId(String userId);
    List<UserSocialInfo> selectCollectUsersByUserId(String userId);

    List<ModelCardInfo> selectCollectModelByUserId(String userId);



    Star collectUser(String userId, String foreignId);

    Star collectModel(String userId, String foreignId);

    Star collectArticle(String userId, String foreignId);


    List<String> selectCollectId(String userId, StarType article);
}
