package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.BannerMapper;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.service.CommonService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.util.ImageNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 天天
 * @create 2023/2/27 14:04
 * @description
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    OssService ossService;



    @Override
    public String uploadBannerImage(MultipartFile file, String foreignId, short type) {
        String path = "banner/" + type + "/" + foreignId + "/" + ImageNameUtil.getImgName(file.getOriginalFilename());
        return ossService.uploadFile(file, path);
    }

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insert(banner);
    }
}
