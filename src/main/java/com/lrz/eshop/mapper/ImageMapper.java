package com.lrz.eshop.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.product.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**  
 *
 * @author 天天  
 * @create 2023/1/19 17:17
 * @description    
 */
@Repository
public interface ImageMapper extends BaseMapper<Image> {
    @Select("select * from image where foreign_id = #{foreignId} AND type = #{type}")
    List<Image> selectByForeignId(String foreignId);

    @Select("select * from image where foreign_id = #{productId} AND type = 2")
    List<Image> selectByProductId(String productId);

}
