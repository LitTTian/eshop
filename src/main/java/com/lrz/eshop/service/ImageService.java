package com.lrz.eshop.service;

import com.lrz.eshop.pojo.common.Image;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 天天
 * @create 2023/3/17 0:11
 * @description
 */
public interface ImageService {

    Image delImgById(String id);

    Image delImg(Image image);

    String uploadImage(MultipartFile file);

    int insertImage(Image image);

    Image linkImage(Image image);

    Integer selectMaxPicSeqByForeignIdAndType(String foreignId, byte type);

    Image selectCoverImageByForeignIdAndType(String foreignId, byte type);

    Image selectCoverImageUrlByModelId(String modelId);
    Image selectCoverImageUrlByArticleId(String articleId);
    // Image selectCoverImageUrlByProductId(String productId);

}
