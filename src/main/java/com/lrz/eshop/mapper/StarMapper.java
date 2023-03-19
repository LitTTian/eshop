package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.article.Article;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.product.Model;
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

    @Select("select count(*) from star where foreign_id = #{articleId} and type = 1")
    Integer selectStarCountByArticleId(String articleId);

    @Select("select * from star where user_id = #{userId} and type = 3 order by create_time desc")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "foreignId", column = "foreign_id"),
            @Result(property = "object", column = "foreign_id", javaType = UserSocialInfo.class,
                    one = @One(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "version", column = "version"),
    })
    List<Star> selectPeopleStarsByUserId(String userId);




}
