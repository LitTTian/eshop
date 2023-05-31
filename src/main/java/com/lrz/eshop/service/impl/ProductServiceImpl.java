package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lrz.eshop.elasticsearch.ElasticSearch;
import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.mapper.common.ImageMapper;
import com.lrz.eshop.mapper.product.CategoryMapper;
import com.lrz.eshop.mapper.product.ModelMapper;
import com.lrz.eshop.mapper.product.ProductMapper;
import com.lrz.eshop.mapper.trade.TradeDetailMapper;
import com.lrz.eshop.mapper.trade.TradeMapper;
import com.lrz.eshop.pojo.common.Image;
import com.lrz.eshop.pojo.common.ImageType;
import com.lrz.eshop.pojo.product.Category;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.service.ImageService;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.service.ProductService;
import com.lrz.eshop.util.ImageNameUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 天天
 * @create 2023/2/26 15:32
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ElasticSearch elasticSearch;

    @Autowired
    RestHighLevelClient restHighLevelClient;

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
    TradeMapper tradeMapper;

    @Autowired
    TradeDetailMapper tradeDetailMapper;

    @Autowired
    ImageService imageService;

    @Autowired
    ImageNameUtil imageNameUtil;

    @Override
    public List<ModelMapping> selectAllModelBySellerId(String sellerId) {
        // return modelMapper.selectBySellerId(sellerId);
        QueryBuilder queryBuilder = QueryBuilders.termQuery("sellerId", sellerId);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(queryBuilder)
                .sort("createTime", SortOrder.DESC)
                .size(200);
        SearchRequest searchRequest = new SearchRequest()
                .indices("models")
                .source(searchSourceBuilder);
        List<ModelMapping> modelMappings = new ArrayList<>();
        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit hit : searchResponse.getHits().getHits()) {
                // System.out.println(hit);
                Map<String, Object> sourceMap = hit.getSourceAsMap();

                // TODO 异常处理
                String id = sourceMap.get("id").toString();
                String title = title = sourceMap.get("title") == null ? null : sourceMap.get("title").toString();
                ;
                String advertisement = advertisement = sourceMap.get("advertisement") == null ? null : sourceMap.get("advertisement").toString();
                ;
                String categoryName = sourceMap.get("categoryName") == null ? null : sourceMap.get("categoryName").toString();
                int starCounts = sourceMap.get("starCounts") == null ? 0 : Integer.parseInt(sourceMap.get("starCounts").toString());
                double lowPrice = sourceMap.get("lowPrice") == null ? 0 : Double.parseDouble(sourceMap.get("lowPrice").toString());
                String coverImgUrl = sourceMap.get("coverImgUrl") == null ? null : sourceMap.get("coverImgUrl").toString();
                String categoryId = sourceMap.get("categoryId") == null ? null : sourceMap.get("categoryId").toString();
                Instant instant = Instant.parse(sourceMap.get("createTime").toString());
                Date createTime = new Date();
                if (instant != null) {
                    createTime = Date.from(instant);
                }
                ModelMapping mapping = new ModelMapping();
                mapping.setId(Long.valueOf(id));
                mapping.setTitle(title);
                mapping.setAdvertisement(advertisement);
                mapping.setCategoryId(Long.valueOf(categoryId));
                mapping.setCategoryName(categoryName);
                mapping.setStarCounts(starCounts);
                mapping.setLowPrice(lowPrice);
                mapping.setCoverImgUrl(coverImgUrl);
                mapping.setSellerId(Long.valueOf(sellerId));
                mapping.setCreateTime(createTime);
                modelMappings.add(mapping);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 封装分页结果
        return modelMappings;
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
    public Model delModel(String sellerId, String modelId) {
        Model model = modelMapper.selectById(modelId);
        if(model == null) {
            return null;
        }
        if(!String.valueOf(model.getSellerId()).equals(sellerId)) {
            return null;
        }
        model.setDeleted(true);
        modelMapper.updateById(model);
        elasticSearch.removeModelMappingByIdFromEs(modelId);
        return model;
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
    public List<Category> selectAllCategory() {
        List<Category> categoryList =  categoryMapper.selectAllCategory();
        return categoryList;
    }


    @Override
    public Product selectProductDetailByProductId(String productId) {
        return productMapper.selectDetailById(productId);
    }


    @Override
    public boolean addModel(Model model) {
        modelMapper.insert(model);
        // System.out.println(model.getId());
        if(model.getId() == null) {
            return false;
        }
        if(model.getProducts() != null) {
            for(Product product : model.getProducts()) {
                product.setModelId(model.getId());
                insertProduct(product);
            }
        }
        if(model.getImages().size() > 0) {
            for(Image image : model.getImages()) {
                image.setForeignId(model.getId());
                image.setType(ImageType.PRODUCT.getCode());
                imageService.linkImage(image);
            }
        }
        ModelMapping modelMapping = modelMapper.selectModelMappingByModelId(String.valueOf(model.getId()));
        elasticSearch.addModelMappingToEs(modelMapping);
        return true;
    }

    @Override
    public Product selectById(String productId) {
        return productMapper.selectById(productId);
    }


}
