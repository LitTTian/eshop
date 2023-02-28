package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 天天
 * @create 2023/2/27 14:05
 * @description
 */
@Api(tags = "common-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @ApiOperation("上传轮播图")
    @PostMapping("/uploadBannerImage")
    public Result<?> uploadBannerImage(@RequestParam("file") MultipartFile file, @RequestParam("foreignId") String foreignId, @RequestParam("type") short type) {
        Banner banner = new Banner();
        banner.setForeignId(Long.valueOf(foreignId));
        banner.setType(type);
        String url = commonService.uploadBannerImage(file, foreignId, type);
        if(url == null) {
            return Result.failed();
        }
        banner.setImgUrl(url);
        commonService.insertBanner(banner);
        return Result.success("更新成功", banner);
    }
}
