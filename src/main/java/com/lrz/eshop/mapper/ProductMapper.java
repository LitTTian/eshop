package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import org.apache.ibatis.annotations.One;
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
            @Result(property = "originalPrice", column = "original_Price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "price", column = "price"),
            @Result(property = "description", column = "description"),
            @Result(property = "seq", column = "seq"),
            @Result(property = "config1", column = "config1"),
            @Result(property = "config2", column = "config2"),
            @Result(property = "config3", column = "config3"),
            @Result(property = "config4", column = "config4"),
            @Result(property = "config5", column = "config5"),
            @Result(property = "gift", column = "gift"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "sellCount", column = "sell_count"),
            // @Result(property = "images", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByProductId")
            // ),
    })
    List<Product> selectByModelId(String modelId);

    // @Select("select max(seq) from product where model_id = #{modelId}")
    @Select("select max(seq) from product where model_id = #{modelId}")
    Integer maxProSeq(String modelId);


    /**
     * 查询一个机型的最高价格
     * @param modelId
     * @return
     */
    @Select("select max(price) from product where model_id = #{modelId}")
    double selectHighPriceByModelId(String modelId);
    /**
     * 查询一个机型的最低价格
     * @param modelId
     * @return
     */
    @Select("select min(price) from product where model_id = #{modelId}")
    double selectLowPriceByModelId(String modelId);

    // stock和count都在ModelMapper中直接多表查询了
    /**
     * 计算总销量
     * @param modelId
     * @return
     */
/*     @Select("select sum(sell_count) from product where model_id = #{modelId}")
    int sumSellCountByModelId(String modelId); */

    /**
     * 计算总库存
     * @param modelId
     * @return
     */
/*     @Select("select sum(stock) from product where model_id = #{modelId}")
    int sumStockByModelId(String modelId); */


    @Select("select * from product where id = #{id}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "modelId", column = "model_id"),
            @Result(property = "originalPrice", column = "original_Price"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "price", column = "price"),
            @Result(property = "description", column = "description"),
            @Result(property = "seq", column = "seq"),
            @Result(property = "config1", column = "config1"),
            @Result(property = "config2", column = "config2"),
            @Result(property = "config3", column = "config3"),
            @Result(property = "config4", column = "config4"),
            @Result(property = "config5", column = "config5"),
            @Result(property = "gift", column = "gift"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "sellCount", column = "sell_count"),

            @Result(property = "model", column = "model_id", javaType = Model.class,
                    one = @One(select = "com.lrz.eshop.mapper.ModelMapper.selectDetailByModelId")
            ),
            // @Result(property = "images", column = "id", javaType = List.class,
            //         many = @Many(select = "com.lrz.eshop.mapper.ImageMapper.selectByProductId")
            // ),
    })
    Product selectDetailById(String id);




}
