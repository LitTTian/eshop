package com.lrz.eshop.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/15 15:47
 * @description
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {


    @Select("select * from article where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    // 用这种方式查出来的category有configs
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "abstracts", column = "abstracts"),
            @Result(property = "content", column = "content"),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByArticleId")
            ),
            // 标签
            @Result(property = "articleTags", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.article.ArticleTagMapper.selectByArticleId")
            ),
            // 浏览、赞、踩
            @Result(property = "watches", column = "watches"),
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
            @Result(property = "commentCount", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.ArticleMapper.selectCommentCountByArticleId")
            ),
            @Result(property = "articleComments", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.article.ArticleCommentMapper.selectByArticleId")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
    })
    Article selectDetailInfoById(String id);

    // @Select("select * from article where category_id = #{categoryId} order by create_time desc limit #{limit}")
    // @Results({
    //         @Result(property = "id", column = "id"),
    //         @Result(property = "userId", column = "user_id"),
    //         @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
    //                 one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
    //         ),
    //         @Result(property = "categoryId", column = "category_id"),
    //         @Result(property = "category", column = "category_id", javaType = Category.class,
    //                 // 用这种方式查出来的category有configs
    //                 one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
    //         ),
    //         @Result(property = "title", column = "title"),
    //         @Result(property = "abstracts", column = "abstracts"),
    //         @Result(property = "content", column = "content"),
    //         @Result(property = "coverImageUrl", column = "id", javaType = String.class,
    //                 one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByArticleId")
    //         ),
    //         // @Result(property = "images", column = "id", javaType = List.class,
    //         //         many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByArticleId")
    //         // ),
    //         @Result(property = "articleTags", column = "id", javaType = List.class,
    //                 many = @Many(select = "com.lrz.eshop.mapper.article.ArticleTagMapper.selectByArticleId")
    //         ),
    //         // 浏览、赞、踩
    //         @Result(property = "watches", column = "watches"),
    //         @Result(property = "likes", column = "id", javaType = Integer.class,
    //                 one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
    //         ),
    //         @Result(property = "dislikes", column = "id", javaType = Integer.class,
    //                 one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
    //         ),
    //         @Result(property = "commentCount", column = "id", javaType = Integer.class,
    //                 one = @One(select = "com.lrz.eshop.mapper.article.ArticleCommentMapper.selectCommentCountByArticleId")
    //         ),
    //         // @Result(property = "articleComments", column = "id", javaType = List.class,
    //         //         many = @Many(select = "com.lrz.eshop.mapper.article.ArticleCommentMapper.selectByArticleId")
    //         // ),
    //         @Result(property = "createTime", column = "create_time"),
    //         @Result(property = "updateTime", column = "update_time"),
    //         @Result(property = "version", column = "version"),
    // })
    // List<Article> selectByCategoryId(String categoryId, int limit);


    // select sum(cnt) from (
    // select count(*) as cnt from article_comment where article_id = 11000001
    // union all
    // select count(*) as cnt from article_comment_child where article_id = 11000001
    //         ) as countdata

    /**
     * 根据文章id查询评论数
     * @param articleId
     * @return
     */
    @Select("select sum(cnt) from (select count(*) as cnt from article_comment where article_id = #{articleId} union all select count(*) as cnt from article_comment_child where article_id = #{articleId}) as countData")
    Integer selectCommentCountByArticleId(String articleId);


    /**
     * 根据类别id查询热门文章详情
     * @param keyword
     * @param key
     * @param limit
     * @return
     */
    @Select("select * from article where ${keyword} = #{key} order by watches desc limit #{limit}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    // 用这种方式查出来的category有configs
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "abstracts", column = "abstracts"),
            // @Result(property = "content", column = "content"),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            // @Result(property = "images", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByArticleId")
            // ),
            // 标签
            // @Result(property = "articleTags", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.article.ArticleTagMapper.selectByArticleId")
            // ),
            // 浏览、赞、踩
            @Result(property = "watches", column = "watches"),
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
            // @Result(property = "commentCount", column = "id", javaType = Integer.class,
            //         one = @One(select = "com.lrz.eshop.mapper.article.ArticleMapper.selectCommentCountByArticleId")
            // ),
            // @Result(property = "articleComments", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.article.ArticleCommentMapper.selectByArticleId")
            // ),
            @Result(property = "createTime", column = "create_time"),
            // @Result(property = "updateTime", column = "update_time"),
            // @Result(property = "version", column = "version"),
    })
    List<ArticleShowInfo> selectMostWatchesArticleCardByKeyword(String keyword, String key, int limit);

    @Select("select * from article where id in (select article_id from (select article_id from article_tag where tag_id = #{tagId} limit #{limit}) as a )")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    // 用这种方式查出来的category有configs
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "abstracts", column = "abstracts"),
            // @Result(property = "content", column = "content"),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            // @Result(property = "images", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByArticleId")
            // ),
            // 标签
            // @Result(property = "articleTags", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.article.ArticleTagMapper.selectByArticleId")
            // ),
            // 浏览、赞、踩
            @Result(property = "watches", column = "watches"),
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
            // @Result(property = "commentCount", column = "id", javaType = Integer.class,
            //         one = @One(select = "com.lrz.eshop.mapper.article.ArticleMapper.selectCommentCountByArticleId")
            // ),
            // @Result(property = "articleComments", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.article.ArticleCommentMapper.selectByArticleId")
            // ),
            @Result(property = "createTime", column = "create_time"),
            // @Result(property = "updateTime", column = "update_time"),
            // @Result(property = "version", column = "version"),
    })
    List<ArticleShowInfo> selectMostWatchesArticleCardByTagId(String tagId, int limit);


    @Select("select * from article order by watches desc limit #{limit}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    // 用这种方式查出来的category有configs
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "abstracts", column = "abstracts"),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            // 浏览、赞、踩
            @Result(property = "watches", column = "watches"),
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
            @Result(property = "createTime", column = "create_time"),
    })
    List<ArticleShowInfo> selectMostWatchesArticleCard(int limit);

}