package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.user.LocationMapper;
import com.lrz.eshop.pojo.user.Location;
import com.lrz.eshop.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天天
 * @create 2023/5/18 18:28
 * @description
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationMapper locationMapper;
    @Override
    public List<Location> selectLocationByUserId(String userId) {
        return locationMapper.selectLocationsByUserId(Long.valueOf(userId));
    }
}
