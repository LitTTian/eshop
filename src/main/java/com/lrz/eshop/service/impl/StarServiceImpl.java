package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.ModelMapper;
import com.lrz.eshop.mapper.StarMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.Likes;
import com.lrz.eshop.pojo.common.LikesState;
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

    @Autowired
    LikeMapper likeMapper;

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


/*     @Override
    public Star star(Star star) {
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", star.getUserId());
        queryWrapper.eq("foreign_id", star.getForeignId());
        if(star.getType() != null)
            queryWrapper.eq("type", star.getType());
        List<Star> stars = starMapper.selectList(queryWrapper);
        if(stars.size() == 0) { // 未收藏
            Star starDB = new Star();
            starDB.setUserId(star.getUserId());
            starDB.setForeignId(star.getForeignId());
            starDB.setType(star.getType());
            starMapper.insert(star);
            return star;
        }
        starMapper.deleteById(stars.get(0));
        return null;
    } */

    @Override
    public Boolean isStared(Star star) {
        return starMapper.exists(new QueryWrapper<Star>()
                .eq("user_id", star.getUserId())
                .eq("foreign_id", star.getForeignId())
                .eq("type", star.getType())
        );
    }


    @Override
    public Likes like(Likes like) {
        QueryWrapper<Likes> likeQueryWrapper = new QueryWrapper<>();
        likeQueryWrapper.eq("user_id", like.getUserId());
        likeQueryWrapper.eq("foreign_id", like.getForeignId());
        likeQueryWrapper.eq("type", like.getType());
        Likes likeDB = likeMapper.selectOne(likeQueryWrapper);
        if (likeDB == null) { // 本身没有值，直接插入
            // 没有值当成点赞处理
            Byte isLike = like.getIsLike() == null? LikesState.LIKES.getCode() : like.getIsLike();
            Likes likeToInsert = new Likes();
            likeToInsert.setUserId(like.getUserId());
            likeToInsert.setForeignId(like.getForeignId());
            likeToInsert.setType(like.getType());
            likeToInsert.setIsLike(isLike);
            likeMapper.insert(likeToInsert);
            return likeToInsert;
        } else { // 数据库有点赞记录
            if(like.getIsLike() == null || like.getIsLike().equals(likeDB.getIsLike())) { // 传入
                // 传入值相同或为空，说明是取消点赞
                likeMapper.deleteById(likeDB);
                return null;
            }
            // 数据库中的值和传入的值不同，说明是相反的操作，直接更新
            likeDB.setIsLike((byte) (LikesState.LIKES.getCode() + LikesState.DISLIKE.getCode() - likeDB.getIsLike()));
            likeMapper.updateById(likeDB);
            return likeDB;
        }
    }

    @Override
    public Byte isLiked(Likes like) {
        Likes likeDB = likeMapper.selectOne(new QueryWrapper<Likes>()
                .eq("user_id", like.getUserId())
                .eq("foreign_id", like.getForeignId())
                .eq("type", like.getType())
        );
        if(likeDB == null) {
            return 0;
        }
        return likeDB.getIsLike();
    }


    /**
     * 收藏
     * @param userId
     * @param foreignId
     * @param starType
     * @return
     */
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
