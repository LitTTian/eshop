package com.lrz.eshop.mapper.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.common.Banner;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * 轮播图
 * @author 天天
 * @create 2023/1/19 17:17
 * @description
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {

    @Select("select * from banner where type = 1")
    @Results({
            // 这里的column是上面select查询的结果，即user表的默认column不再是驼峰！！！
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type"),
            @Result(property = "foreignId", column = "foreign_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "imgUrl", column = "foreign_id", javaType = String.class,
                    one = @One(select = "com.lrz.eshop.mapper.common.ImageMapper.selectCoverImageUrlByModelId")
            ),
    })
    List<Banner> getAllHomeBanner();

}
