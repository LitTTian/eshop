package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.user.Location;
import com.lrz.eshop.service.LocationService;
import com.lrz.eshop.util.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 地址控制类
 * @author 天天
 * @create 2023/5/18 18:23
 * @description
 */
@Api(tags = "location-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LocationService locationService;

    @RequestMapping("/getMyLocation")
    public Result<?> getMyLocation() {
        String token = request.getHeader("Authorization");
        String userId = TokenUtil.getIdByToken(token);
        List<Location> locations = locationService.selectLocationByUserId(userId);
        return Result.success("查询成功", locations);
    }
}
