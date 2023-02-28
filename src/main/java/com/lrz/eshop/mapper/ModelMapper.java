package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Model;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
     * 获得最新的十条记录
     * @param limit
     * @return
     */
    @Select("select * from model order by create_time desc limit #{limit}")
    List<Model> selectNewModel(int limit);


    @Select("select * from model order by sell_count desc limit #{limit}")
    List<Model> selectHotModel(int limit);


    /**
     * 查询用户上架的全部机型
     * @param sellerId
     * @return
     */
    @Select("select * from model where seller_id = #{sellerId}")
    List<Model> selectBySellerId(String sellerId);


    /**
     * 根据modelId查询该机型的所有产品
     * @param modelId
     * @return
     */
    @Select("select * from model where id = #{modelId}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "advertisement", column = "advertisement"),
            @Result(property = "coverImgUrl", column = "cover_img_url"),
            @Result(property = "sellerId", column = "seller_id"),
            // @Result(property = "configMain", column = "config_main"),
            // 将具体config写到Category里
            // @Result(property = "config1", column = "config1"),
            // @Result(property = "config2", column = "config2"),
            // @Result(property = "config3", column = "config3"),
            // @Result(property = "config4", column = "config4"),
            // @Result(property = "config5", column = "config5"),
            @Result(property = "starCount", column = "star_count"),
            @Result(property = "sellCount", column = "sell_count"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "version", column = "version"),
            @Result(property = "products", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ProductMapper.selectByModelId")
            ),
    })
    Model selectAllProductsByModelId(String modelId);


}
