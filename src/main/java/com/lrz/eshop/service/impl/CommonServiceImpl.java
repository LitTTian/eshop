package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.BannerMapper;
import com.lrz.eshop.mapper.CategoryMapper;
import com.lrz.eshop.mapper.StarMapper;
import com.lrz.eshop.mapper.article.ArticleMapper;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.article.Like;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.service.CommonService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.util.ImageNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/27 14:04
 * @description
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    BannerMapper bannerMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    OssService ossService;

    @Autowired
    ImageNameUtil imageNameUtil;

    @Autowired
    StarMapper starMapper;

    @Autowired
    LikeMapper likeMapper;

    @Autowired
    ArticleMapper articleMapper;



    @Override
    public String uploadBannerImage(MultipartFile file, String foreignId, short type) {
        String path = "banner/" + type + "/" + foreignId + "/" + imageNameUtil.getImgName(file.getOriginalFilename());
        return ossService.uploadFile(file, path);
    }

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insert(banner);
    }

    @Override
    public List<Banner> getAllHomeBanner() {
        List<Banner> banners = bannerMapper.getAllHomeBanner();
        for(Banner banner : banners) {
            banner.setHrefUrl("/product/" + banner.getForeignId());
        }
        return banners;
    }

    public List<Category> selectAllCategoryWithTopModel() {
        return categoryMapper.selectAllCategoryWithTopModel();
    }

    @Override
    public Star star(Star star) {
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", star.getUserId());
        queryWrapper.eq("foreign_id", star.getForeignId());
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
    }

    @Override
    public Boolean isStared(Star star) {
        return starMapper.exists(new QueryWrapper<Star>()
                .eq("user_id", star.getUserId())
                .eq("foreign_id", star.getForeignId())
                .eq("type", star.getType())
        );
    }


    @Override
    public Like like(Like like) {
        QueryWrapper<Like> likeQueryWrapper = new QueryWrapper<>();
        likeQueryWrapper.eq("user_id", like.getUserId());
        likeQueryWrapper.eq("foreign_id", like.getForeignId());
        likeQueryWrapper.eq("type", like.getType());

        Like likeDB = likeMapper.selectOne(likeQueryWrapper);

        if (likeDB == null) { // 本身没有值，直接插入
            // 没有值当成点赞处理
            Short isLike = like.getIsLike() == null? 1 : like.getIsLike();
            Like likeToInsert = new Like();
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
            likeDB.setIsLike((short) (3 - likeDB.getIsLike()));
            likeMapper.updateById(likeDB);
            return likeDB;
        }
    }

    @Override
    public Short isLiked(Like like) {
        Like likeDB = likeMapper.selectOne(new QueryWrapper<Like>()
                .eq("user_id", like.getUserId())
                .eq("foreign_id", like.getForeignId())
                .eq("type", like.getType())
        );
        if(likeDB == null) {
            return 0;
        }
        return likeDB.getIsLike();
    }

    @Override
    public List<ArticleShowInfo> selectMostWatchesArticleCardByCategoryId(String categoryId) {
        return articleMapper.selectMostWatchesArticleCardByCategoryId(categoryId, 10);
    }

    @Override
    public List<ArticleShowInfo> selectMostWatchesArticleCard() {
        return articleMapper.selectMostWatchesArticleCard(10);
    }


}
