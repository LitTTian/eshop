package com.lrz.eshop.mapper.common;


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
    List<Image> selectByForeignId(String foreignId, int type);

    // @Select("select * from image where foreign_id = #{productId} AND type = 2")
    // List<Image> selectByProductId(String productId);

    @Select("select * from image where foreign_id = #{modelId} AND type = 1 order by seq")
    List<Image> selectByModelId(String modelId);

    @Select("select * from image where foreign_id = #{articleId} AND type = 4 order by seq")
    List<Image> selectByArticleId(String articleId);



    @Select("select max(seq) from image where foreign_id = #{foreignId} AND type = #{type}")
    Integer maxPicSeq(String foreignId, int type);

    @Select("select img_url from image where foreign_id = #{modelId} AND type = 1 order by seq limit 1")
    String selectCoverImageUrlByModelId(String modelId);

    @Select("select img_url from image where foreign_id = #{articleId} AND type = 4 order by seq limit 1")
    String selectCoverImageUrlByArticleId(String articleId);

}
