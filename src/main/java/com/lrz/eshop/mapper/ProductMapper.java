package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Product;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 14:43
 * @description
 */
@Repository
public interface ProductMapper extends BaseMapper<Product> {


    @Select("select * from product where model_id = #{modelId}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "modelId", column = "model_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "description", column = "description"),
            @Result(property = "seq", column = "seq"),
            @Result(property = "configMain", column = "config_main"),
            @Result(property = "config1", column = "config1"),
            @Result(property = "config2", column = "config2"),
            @Result(property = "config3", column = "config3"),
            @Result(property = "config4", column = "config4"),
            @Result(property = "config5", column = "config5"),
            @Result(property = "mainImgUrl", column = "main_img_url"),
            @Result(property = "gift", column = "gift"),
            @Result(property = "stackCnt", column = "stack_cnt"),
            @Result(property = "sellCnt", column = "sell_cnt"),
            @Result(property = "onSale", column = "on_sale"),
            @Result(property = "images", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByProductId")
            ),
    })
    Product selectByModelId(String modelId);

    // @Select("select max(seq) from product where model_id = #{modelId}")
    @Select("select count(*) from product where model_id = #{modelId}")
    int maxSeq(String modelId);


}
