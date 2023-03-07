package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.BannerMapper;
import com.lrz.eshop.mapper.CategoryMapper;
import com.lrz.eshop.pojo.common.Banner;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.service.CommonService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.util.ImageNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    CategoryMapper categoryMapper;

    @Autowired
    OssService ossService;

    @Autowired
    ImageNameUtil imageNameUtil;



    @Override
    public String uploadBannerImage(MultipartFile file, String foreignId, short type) {
        String path = "banner/" + type + "/" + foreignId + "/" + imageNameUtil.getImgName(file.getOriginalFilename());
        return ossService.uploadFile(file, path);
    }

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insert(banner);
    }

    @Override
    public List<Banner> getAllHomeBanner() {
        List<Banner> banners = bannerMapper.getAllHomeBanner();
        for(Banner banner : banners) {
            banner.setHrefUrl("/product/" + banner.getForeignId());
        }
        return banners;
    }

    public List<Category> selectAllCategoryWithTopModel() {
        return categoryMapper.selectAllCategoryWithTopModel();
    }


}
