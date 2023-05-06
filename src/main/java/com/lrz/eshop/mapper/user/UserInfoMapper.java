package com.lrz.eshop.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.user.*;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author 天天
 * @create 2023/4/19 15:25
 * @description
 */

@Repository
public interface UserInfoMapper extends BaseMapper<User> {


    @Select("select count(*) from star where user_id = #{userId} and type = 3")
    public int peopleStarCount(String userId); // 关注的人的数量
    @Select("select count(*) from star where foreign_id = #{userId} and type = 3")
    public int fansCount(String userId);

    /**
     * 根据id查询用户的社交信息
     * 必须包括：id、nickname、avatarUrl、createTime
     * 通过UserSocialInfo类,可以不需要这个方法
     * @param id
     * @return
     */
    // @Select("Select * from user where id = #{id}")
    @Select("Select * from user where id = #{id}")
    UserSocialInfo getUserSocialInfo(String id);

    // private int articleCount; // 文章的数量
    //         private int articleStaredCount; // 文章被收藏的次数
    //         private int articleCommentCount; // 文章被评论的次数
    //         private int peopleStarCount; // 关注的人的数量
    //         private int fansCount; // 粉丝的数量

    @Select("select sum(watches) as watches, count(*) as article_count, #{userId} as user_id from article where user_id = #{userId}")
    @Results({
            @Result(property = "id", column = "user_id"),
            @Result(property = "articleCount", column = "article_count"),
            @Result(property = "articleStaredCount", column = "user_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.articleStaredCount")
            ),
            @Result(property = "articleCommentCount", column = "user_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.articleCommentCount")
            ),
            @Result(property = "articleReadCount", column = "watches"),
            @Result(property = "articleLikedCount", column = "user_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.articleLikedCount")
            ),
            @Result(property = "peopleStarCount", column = "user_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.peopleStarCount")
            ),
            @Result(property = "fansCount", column = "user_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.fansCount")
            ),
    })
    public UserCommunityInfo getUserCommunityInfo(String userId);
    // @Select("select count(*) from article where user_id = #{userId}")
    // public int articleCount(String userId);
    @Select("select count(*) from star where foreign_id in (select id from article where user_id = #{userId}) and type = 1")
    public int articleStaredCount(String userId);
    @Select("select sum(cnt) from (select count(*) as cnt from article_comment where article_id in(select id from article where article.user_id = #{userId}) union all select count(*) as cnt from article_comment_child where article_id in(select id from article where article.user_id = #{userId}))as countData")
    public int articleCommentCount(String userId);

    // @Select("select sum(watches) from article where user_id = #{userId}")
    // public int articleReadCount(String userId);

    @Select("select count(*) from likes where foreign_id in (select id from article where article.user_id = #{userId}) and type = 1 and is_like = 1")
    public int articleLikedCount(String userId);


    /**
     * 获取用户的销售信息
     * @param userId
     * @return
     */
    @Select("select count(*) as counts, #{userId} as seller_id from model where seller_id = #{userId}")
    @Results({
            @Result(property = "id", column = "seller_id"),
            @Result(property = "modelSellCount", column = "seller_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.modelSellCount")
            ),
            @Result(property = "modelStaredCount", column = "seller_id", javaType = Integer.class,
                    one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.modelStaredCount")
            ),
            @Result(property = "modelCount", column = "counts"),
    })
    public UserSellInfo getUserSellInfo(String userId);
    @Select("select sum(count) from trade_detail where product_id in (select id from product where model_id in (select id from model where seller_id = #{userId}))")
    public int modelSellCount(String userId);

    @Select("select count(*) from star where foreign_id in (select id from model where seller_id = #{userId}) and type = 2")
    public int modelStaredCount(String userId);


    // @Select("select count(*) from model where seller_id = #{userId}")
    // public int modelCount(String userId);

}
