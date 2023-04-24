package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.ModelMapper;
import com.lrz.eshop.mapper.StarMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.common.StarType;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.ModelCardInfo;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import com.lrz.eshop.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天天
 * @create 2023/4/22 2:22
 * @description
 */
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StarMapper starMapper;

    @Override
    public List<ArticleShowInfo> selectCollectArticleByUserId(String userId) {
        return starMapper.selectCollectArticleByUserId(userId);
    }

    @Override
    public List<UserSocialInfo> selectCollectUsersByUserId(String userId) {
        return starMapper.selectCollectUserByUserId(userId);
    }

    @Override
    public List<ModelCardInfo> selectCollectModelByUserId(String userId) {
        List<ModelCardInfo> modelCardInfos = starMapper.selectCollectModelByUserId(userId);
        System.out.println(modelCardInfos);
        return modelCardInfos;
    }

    @Override
    public Star collectUser(String userId, String foreignId) {
        return star(userId, foreignId, StarType.USER);
    }

    @Override
    public Star collectModel(String userId, String foreignId) {
        return star(userId, foreignId, StarType.PRODUCT);
    }

    @Override
    public Star collectArticle(String userId, String foreignId) {
        return star(userId, foreignId, StarType.ARTICLE);
    }

    @Override
    public List<String> selectCollectId(String userId, StarType article) {
        return starMapper.selectForeignIdByUserIdAndType(userId, article.getCode());
    }


    public Star star(String userId, String foreignId, StarType starType) {
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("foreign_id", foreignId);
        queryWrapper.eq("type", starType.getCode());
        List<Star> stars = starMapper.selectList(queryWrapper);
        if(stars.size() == 0) { // 未收藏
            Star starDB = new Star();
            starDB.setUserId(Long.parseLong(userId));
            starDB.setForeignId(Long.parseLong(foreignId));
            starDB.setType(starType.getCode());
            starMapper.insert(starDB);
            return starDB;
        }
        starMapper.deleteById(stars.get(0));
        return null;
    }


}
