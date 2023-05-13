package com.lrz.eshop.mapper.common;

import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/5/8 13:07
 * @description
 */
@Repository
public interface SearchMapper {
    // 搜索
    /**
     * 根据关键字搜索文章
     * @param keyword
     * @param order
     * @return
     */
    @Select("select * from article where (title like CONCAT('%', #{keyword} ,'%') OR abstracts like CONCAT('%', #{keyword} ,'%') ) and type = 1 order by #{order} desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.product.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "abstracts", column = "abstracts"),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.common.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            // 浏览、赞、踩
            @Result(property = "watches", column = "watches"),
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.star.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    List<ArticleShowInfo> selectArticleByKeywordOrder(String keyword, String order);


    @Select("select * from article where category_id = #{categoryId} and type = 1 order by #{order} desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.product.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "abstracts", column = "abstracts"),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.common.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            // 浏览、赞、踩
            @Result(property = "watches", column = "watches"),
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.star.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    List<ArticleShowInfo> selectArticleByCategoryIdOrder(String categoryId, String order);
}
