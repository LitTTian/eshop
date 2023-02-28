package com.lrz.eshop.service;

import com.lrz.eshop.mapper.BannerMapper;
import com.lrz.eshop.pojo.common.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 天天
 * @create 2023/2/27 14:03
 * @description
 */
public interface CommonService {


    String uploadBannerImage(MultipartFile file, String foreignId, short type);

    int insertBanner(Banner banner);
}