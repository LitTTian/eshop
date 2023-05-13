package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.common.BannerMapper;
import com.lrz.eshop.mapper.product.CategoryMapper;
import com.lrz.eshop.mapper.star.StarMapper;
import com.lrz.eshop.mapper.article.ArticleMapper;
import com.lrz.eshop.mapper.article.LikeMapper;
import com.lrz.eshop.mapper.article.TagMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.*;
import com.lrz.eshop.pojo.article.Tag;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.service.CommonService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.util.ImageNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

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

    @Autowired
    TagMapper tagMapper;



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
    public List<Tag> hotTags() {
        return tagMapper.selectHotTags();
    }


    @Override
    public List<ArticleShowInfo> selectMostWatchesArticleCard() {
        return articleMapper.selectMostWatchesArticleCard(5);
    }


    @Override
    public List<ArticleShowInfo> selectMostWatchesArticleCardByKeyword(String keyword, String key) {
        if(Objects.equals(keyword, "tag")) {
            return articleMapper.selectMostWatchesArticleCardByTagId(key, 10);
        } else if(Objects.equals(keyword, "category")) {
            keyword = "category_id";
        } else if(Objects.equals(keyword, "user")) {
            keyword = "user_id";
        }
        return articleMapper.selectMostWatchesArticleCardByKeyword(keyword, key, 10);
    }


}
