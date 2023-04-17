package com.lrz.eshop.service;

import com.lrz.eshop.mapper.BannerMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.article.Like;
import com.lrz.eshop.pojo.article.Tag;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.product.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/27 14:03
 * @description
 */
public interface CommonService {


    String uploadBannerImage(MultipartFile file, String foreignId, short type);

    int insertBanner(Banner banner);

    List<Banner> getAllHomeBanner();

    List<Category> selectAllCategoryWithTopModel();

    List<Tag> hotTags();


    // 点赞和收藏

    Star star(Star star);

    Boolean isStared(Star star);

    /**
     * 点赞
     * @param like
     * @return
     */
    public Like like(Like like);


    /**
     * 0:未操作 1:点赞 2:踩
     * @param like
     * @return 0:未操作 1:点赞 2:踩
     */
    Short isLiked(Like like);


    List<ArticleShowInfo> selectMostWatchesArticleCard();


    List<ArticleShowInfo> selectMostWatchesArticleCardByKeyword(String keyword, String key);
}
