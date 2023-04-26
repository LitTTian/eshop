package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.product.Category;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 14:42
 * @description
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {


    @Select("select * from category")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "configs", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ConfigMapper.configNames")
            ),
    })
    List<Category> selectAllCategory();

    // @Select("select name from category where id = #{categoryId}")
    // String selectNameByCategoryId(String categoryId);
    @Select("select * from category where id = #{categoryId}")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "configs", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ConfigMapper.configNames")
            ),
    })
    Category selectCategoryByCategoryId(String categoryId);


    /**
     * 查询所有的分类，包括分类下的model
     * @return
     */
    @Select("select * from category")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            /* @Result(property = "configs", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ConfigMapper.configNames")
            ), */
            @Result(property = "models", column = "id", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.ModelMapper.selectTopModelByCategoryId")
            ),
    })
    List<Category> selectAllCategoryWithTopModel();

}
