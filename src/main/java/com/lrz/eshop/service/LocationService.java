package com.lrz.eshop.service;

import com.lrz.eshop.pojo.user.Location;

import java.util.List;

/**
 * @author 天天
 * @create 2023/5/18 18:28
 * @description
 */
public interface LocationService {
    List<Location> selectLocationByUserId(String userId);
}
