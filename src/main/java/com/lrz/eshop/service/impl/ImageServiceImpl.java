package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.common.ImageMapper;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.common.ImageType;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.service.ImageService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.service.ProductService;
import com.lrz.eshop.util.ImageNameUtil;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * @author 天天
 * @create 2023/3/17 0:11
 * @description
 */

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageMapper imageMapper;

    // @Autowired
    // ProductService productService;

    @Autowired
    OssService ossService;

    @Autowired
    ImageNameUtil imageNameUtil;

    @Override
    public Image delImgById(String id) {
        Image image = imageMapper.selectById(id);
        String imgUrl = image.getImgUrl();
        if(imgUrl == null) {
            return null;
        }else {
            ossService.deleteFile(imgUrl);
        }
        return image;
    }

    @Override
    public Image delImg(Image image) {
        Image imageDB = imageMapper.selectById(image.getId());
        if(imageDB == null) {
            return null;
        }
        String delUrl = imageDB.getImgUrl();
        if(!Objects.equals(delUrl, image.getImgUrl())) {
            return null;
        }
        // 删除oss中的图片
        ossService.deleteFile(delUrl);
        // 删除数据库中的记录
        imageMapper.deleteById(imageDB);
        return imageDB;
    }

    @Override
    public String uploadImage(MultipartFile file) {
        String path="testUpload/" + imageNameUtil.getImgName(file.getOriginalFilename());
        return ossService.uploadFile(file, path);
    }

    @Override
    public int insertImage(Image image) {
        return imageMapper.insert(image);
    }

    @Override
    public Image linkImage(Image image) {
        if(image.getType() == null || image.getForeignId() == null) {
            return null;
        }
        Image imageDB = imageMapper.selectById(image.getId());
        if(imageDB == null) {
            return null;
        }
        String delUrl = imageDB.getImgUrl();
        if(!Objects.equals(delUrl, image.getImgUrl())) {
            return null;
        }
        imageDB.setForeignId(image.getForeignId());
        imageDB.setType(image.getType());
        Integer seq = selectMaxPicSeqByForeignIdAndType(image.getForeignId().toString(), image.getType());
        if(seq == null) seq = 0;
        imageDB.setSeq(seq + 1);
        imageMapper.updateById(imageDB);
        return imageDB;
    }

    @Override
    public Integer selectMaxPicSeqByForeignIdAndType(String foreignId, byte type) {
        return imageMapper.maxPicSeq(foreignId, type);
    }

    @Override
    public Image selectCoverImageByForeignIdAndType(String foreignId, byte type) {
        QueryWrapper<Image> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("foreign_id", foreignId);
        queryWrapper.eq("type", type);
        Image image = imageMapper.selectOne(queryWrapper);
        return image;
    }

    @Override
    public Image selectCoverImageUrlByModelId(String modelId) {
        return selectCoverImageByForeignIdAndType(modelId, ImageType.PRODUCT.getCode());
    }

    @Override
    public Image selectCoverImageUrlByArticleId(String articleId) {
        return selectCoverImageByForeignIdAndType(articleId, ImageType.ARTICLE.getCode());
    }

/*    @Override
    public Image selectCoverImageUrlByProductId(String productId) {
        Product product = productService.selectById(productId);
        return selectCoverImageByForeignIdAndType(String.valueOf(product.getModelId()), ImageType.PRODUCT.getCode());
    }*/


}
