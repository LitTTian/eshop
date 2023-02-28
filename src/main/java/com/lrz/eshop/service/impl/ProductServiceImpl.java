package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.mapper.CategoryMapper;
import com.lrz.eshop.mapper.ModelMapper;
import com.lrz.eshop.mapper.ProductMapper;
import com.lrz.eshop.mapper.UserMapper;
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
        return modelMapper.selectAllProductsByModelId(modelId);
    }

    @Override
    public Model selectModelById(String modelId) {
        return modelMapper.selectById(modelId);
    }

    @Override
    public String uploadModelCoverImage(MultipartFile file, Model model) {
        String originPath = model.getCoverImgUrl();
        if(originPath != null && !originPath.equals("")) {
            if(!ossService.deleteFile(originPath)) {
                return null;
            }
        }
        String path = "models/" + model.getId() + "/cover/" + ImageNameUtil.getImgName(file.getOriginalFilename());
        return ossService.uploadFile(file, path);
    }


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
        int max = productMapper.maxSeq(product.getModelId().toString());
        product.setSeq(max + 1);
        return productMapper.insert(product);
    }

    @Override
    public List<Model> selectModelByCategoryId(String categoryId) {
        QueryWrapper<Model> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", categoryId);
        return modelMapper.selectList(queryWrapper);
    }

    @Override
    public int selectMaxSeqByModelId(String modelId) {
        return productMapper.maxSeq(modelId);
    }


}
