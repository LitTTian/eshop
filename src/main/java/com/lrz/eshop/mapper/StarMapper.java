package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.ModelCardInfo;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**  
 *
 * @author 天天  
 * @create 2023/1/19 17:17
 * @description    
 */
@Repository
public interface StarMapper extends BaseMapper<Star> {

    @Select("select * from star where user_id = #{userId} and type = 2 order by create_time desc")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "foreignId", column = "foreign_id"),
            @Result(property = "object", column = "foreign_id", javaType = Model.class,
                    one = @One(select = "com.lrz.eshop.mapper.ModelMapper.selectDetailByModelId")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "version", column = "version"),
    })
    List<Star> selectModelStarsByUserId(String userId);

    @Select("select * from star where user_id = #{userId} and type = 1 order by create_time desc")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "foreignId", column = "foreign_id"),
            @Result(property = "object", column = "foreign_id", javaType = Article.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.ArticleMapper.selectDetailInfoById")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "version", column = "version"),
    })
    List<Star> selectArticleStarsByUserId(String userId);

    @Select("select * from star where user_id = #{userId} and type = 3 order by create_time desc")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "foreignId", column = "foreign_id"),
            @Result(property = "object", column = "foreign_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "version", column = "version"),
    })
    List<Star> selectPeopleStarsByUserId(String userId);

    @Select("select count(*) from star where foreign_id = #{articleId} and type = 1")
    Integer selectStarCountByArticleId(String articleId);





    // 修改后的star查询方法
    @Select("select model.*, star.create_time as star_time from model,star where star.user_id = #{userId} and model.id = star.foreign_id and model.id in (select foreign_id from star where user_id = #{userId} and type = 2 ) order by star_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
    })
    List<ModelCardInfo> selectCollectModelByUserId(String userId);

    /**
     * 关注的人
     */
    @Select("Select user.*, star.create_time as star_time from user, star where star.user_id = #{userId} and user.id = star.foreign_id and user.id in (select foreign_id from star where user_id = #{userId} and type = 3) order by star_time desc")
    List<UserSocialInfo> selectCollectUserByUserId(String userId);

    @Select("Select article.*, star.create_time as star_time from article, star where star.user_id = #{userId} and article.id = star.foreign_id and article.id in (select foreign_id from star where user_id = #{userId} and type = 1) order by star_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "categoryId", column = "category_id"),

            @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    // 用这种方式查出来的category有configs
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "coverImageUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByArticleId")
            ),
            // 浏览、赞、踩
            @Result(property = "stars", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.StarMapper.selectStarCountByArticleId")
            ),
            @Result(property = "likes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectLikeCountByArticleId")
            ),
            @Result(property = "dislikes", column = "id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.article.LikeMapper.selectDislikeCountByArticleId")
            ),
    })
    List<ArticleShowInfo> selectCollectArticleByUserId(String userId);

    // 获取收藏的ForeignId
    @Select("select foreign_id from star where user_id = #{userId} and type = #{type}")
    List<String> selectForeignIdByUserIdAndType(@Param("userId") String userId, @Param("type") Byte type);

}
