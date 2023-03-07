package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.CategoryMapper;
import com.lrz.eshop.mapper.ImageMapper;
import com.lrz.eshop.mapper.ModelMapper;
import com.lrz.eshop.mapper.ProductMapper;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.service.ProductService;
import com.lrz.eshop.util.ImageNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * @author 天天
 * @create 2023/2/26 15:32
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    OssService ossService;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    ImageNameUtil imageNameUtil;

    @Override
    public List<Model> selectAllModelBySellerId(String sellerId) {
        return modelMapper.selectBySellerId(sellerId);
    }

    @Override
    public List<Model> selectNewModel(int limit) {
        return modelMapper.selectNewModel(limit);
    }

    @Override
    public List<Model> selectHotModel(int limit) {
        return modelMapper.selectHotModel(limit);
    }

    @Override
    public Model selectAllProductByModelId(String modelId) {
        return modelMapper.selectAllProductByModelId(modelId);
    }

    @Override
    public Model selectModelById(String modelId) {
        return modelMapper.selectById(modelId);
    }

/*     @Override
    public String uploadModelCoverImage(MultipartFile file, Model model) {
        String originPath = model.getCoverImgUrl();
        if(originPath != null && !originPath.equals("")) {
            if(!ossService.deleteFile(originPath)) {
                return null;
            }
        }
        String path = "products/" + model.getCategoryId() + "/" + model.getId() + "/cover" + imageNameUtil.getImageExtension(file.getOriginalFilename());
        return ossService.uploadFile(file, path);
    } */


    @Override
    public int updateModel(Model model) {
        return modelMapper.updateById(model);
    }

    @Override
    public int updateProduct(Product product) {
        return productMapper.updateById(product);
    }

    @Override
    public int insertModel(Model model) {
        return modelMapper.insert(model);
    }

    @Override
    public int insertProduct(Product product) {
        List<String> cfgs = product.getConfigs();
        System.out.println(cfgs);
        int maxCount = cfgs.size();
        if(0 < maxCount) product.setConfig1(cfgs.get(0));
        if(1 < maxCount) product.setConfig2(cfgs.get(1));
        if(2 < maxCount) product.setConfig3(cfgs.get(2));
        if(3 < maxCount) product.setConfig4(cfgs.get(3));
        if(4 < maxCount) product.setConfig5(cfgs.get(4));
        if(product.getSeq() == 0) {
            Integer seq = selectMaxProSeqByModelId(product.getModelId().toString());
            if(seq == null) seq = 0;
            product.setSeq(seq + 1);
        }
        return productMapper.insert(product);
    }

    @Override
    public List<Model> selectModelByCategoryId(String categoryId) {
        QueryWrapper<Model> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        return modelMapper.selectList(queryWrapper);
    }

    @Override
    public Integer selectMaxProSeqByModelId(String modelId) {
        return productMapper.maxProSeq(modelId);
    }

    @Override
    public Integer selectMaxPicSeqByModelId(String modelId) {
        return imageMapper.maxPicSeq(modelId, 1);
    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> categoryList =  categoryMapper.selectAllCategory();
        return categoryList;
    }

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
        ossService.deleteFile(delUrl);
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
        Integer seq = selectMaxPicSeqByModelId(image.getForeignId().toString());
        if(seq == null) seq = 0;
        imageDB.setSeq(seq + 1);
        imageMapper.updateById(imageDB);
        return imageDB;
    }

    @Override
    public Product selectProductDetailByProductId(String productId) {
        return productMapper.selectDetailById(productId);
    }


}
