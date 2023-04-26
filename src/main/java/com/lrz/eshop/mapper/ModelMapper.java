package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.ModelCardInfo;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 14:38
 * @description
 */
@Repository
public interface ModelMapper extends BaseMapper<Model> {


    /**
     * 通过categoryId查询该分类下的最热门(销量)的有限个model
     * @param categoryId
     * @param limit
     * @return
     */
    @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1 JOIN model ON t1.model_id = model.id AND model.category_id = #{categoryId} WHERE model.deleted = false ORDER BY total DESC LIMIT #{limit}")
    // @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1, model WHERE t1.model_id = model.id AND category_id = #{categoryId} ORDER BY total DESC LIMIT #{limit}")
    // @Select("select * from model where category_id = #{categoryId} order by sell_count desc limit #{limit}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ),
    })
    List<Model> selectHotModelByCategoryId(String categoryId, int limit);

    /**
     * 获得最新的十个model
     * @param limit
     * @return
     */
    // @Select("select * from model order by create_time desc limit #{limit}")
    @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1 JOIN model ON t1.model_id = model.id WHERE model.deleted = false ORDER BY create_time DESC LIMIT #{limit}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ),
    })
    List<Model> selectNewModel(int limit);


    /**
     * 获得最热的十个model(按销量排序)
     * @param limit
     * @return
     */
    // @Select("select * from model order by sell_count desc limit #{limit}")
    @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1 JOIN model ON t1.model_id = model.id WHERE model.deleted = false ORDER BY total DESC LIMIT #{limit}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ),
    })
    List<Model> selectHotModel(int limit);


    /**
     * 按userId查询用户上架的全部model
     * @param sellerId
     * @return
     */
    @Select("select * from model where seller_id = #{sellerId} and deleted = false order by create_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            // @Result(property = "categoryId", column = "category_id"),
/*             @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ), */
            @Result(property = "title", column = "title"),
            // @Result(property = "advertisement", column = "advertisement"),
/*             @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ), */
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            // @Result(property = "sellerId", column = "seller_id"),
            // @Result(property = "starCount", column = "star_count"),
/*             @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"), */
            @Result(property = "createTime", column = "create_time"),
            // @Result(property = "updateTime", column = "update_time"),
            // @Result(property = "version", column = "version"),
/*             @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ), */
    })
    List<Model> selectBySellerId(String sellerId);


    /**
     * 根据modelId查询model,包含具体product信息
     * @param modelId
     * @return
     */
    // @Select("select * from model where id = #{modelId}")
    @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1 JOIN model ON t1.model_id = model.id AND model.id = #{modelId} where model.deleted = false")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ),
    })
    Model selectAllProductByModelId(String modelId);

    /**
     * 根据categoryId查询在querytop中的所有model
     * @param categoryId
     * @return
     */
    @Select("select * from model where id in (select model_id from querytop) and category_id = #{categoryId} and model.deleted = false")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
/*             @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ), */
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
/*             @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ), */
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "starCount", column = "star_count"),
/*             @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"), */
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
/*             @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ), */
    })
    List<Model> selectTopModelByCategoryId(String categoryId);

    /**
     * 根据keyword和order查询model
     * @param keyword
     * @param order
     * @return
     */
    @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1 JOIN model ON t1.model_id = model.id AND model.deleted = false AND (model.title like CONCAT('%', #{keyword} ,'%') OR model.advertisement like CONCAT('%', #{keyword} ,'%') ) ORDER BY #{order} DESC")
    // @Select("select * from model where title like CONCAT('%',#{keywords},'%') or advertisement like CONCAT('%',#{keywords},'%') order by #{order} desc")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
/*             @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ), */
    })
    List<Model> selectModelByKeywordOrder(String keyword, String order);


    /**
     * 根据modelId查询model,包含具体product信息
     * @param modelId
     * @return
     */
    // @Select("select * from model where id = #{modelId}")
    @Select("SELECT * FROM (SELECT model_id, SUM(sell_count) AS total, SUM(stock) AS stk FROM product GROUP BY model_id)t1 JOIN model ON t1.model_id = model.id AND model.id = #{modelId} where model.deleted = false")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            // Category的详细信息
            @Result(property = "category", column = "category_id", javaType = Category.class,
                    one = @One(select = "com.lrz.eshop.mapper.CategoryMapper.selectCategoryByCategoryId")
            ),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "highPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectHighPriceByModelId")
            ),
            @Result(property = "lowPrice", column = "id", javaType = Double.class,
                    one = @One(select = "com.lrz.eshop.mapper.ProductMapper.selectLowPriceByModelId")
            ),
            @Result(property = "coverImgUrl", column = "id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.ImageMapper.selectCoverImageUrlByModelId")
            ),
            @Result(property = "sellerId", column = "seller_id"),
            @Result(property = "seller", column = "seller_id", javaType = UserSocialInfo.class, // 包含seller的社交信息
                    one = @One(select = "com.lrz.eshop.mapper.UserInfoMapper.getUserSocialInfo")
            ),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "total"),
            @Result(property = "stock", column = "stk"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            /* @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByModelId")
            ), */
            /* @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ), */
    })
    Model selectDetailByModelId(String modelId);


}
