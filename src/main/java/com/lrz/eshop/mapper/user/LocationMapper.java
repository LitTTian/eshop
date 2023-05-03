package com.lrz.eshop.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.user.Location;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/7 23:30
 * @description
 */
@Repository
public interface LocationMapper extends BaseMapper<Location> {

    @Select("select * from location where user_id = #{userId} and deleted = 0 order by seq desc")
    List<Location> selectLocationsByUserId(Long userId);

    // select max(seq) from location where user_id = 70260777
    @Select("select max(seq) from location where user_id = #{userId} and deleted = 0")
    Integer selectMaxSeqByUserId(String userId);

}
