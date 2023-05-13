package com.lrz.eshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.eshop.common.page.MyPageInfo;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.mapper.common.SearchMapper;
import com.lrz.eshop.mapper.product.ModelMapper;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.service.SearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
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
 * @create 2023/3/3 14:37
 * @description
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    SearchMapper searchMapper;

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public PageInfo<Model> findPageByKeywordOrder(Integer page, Integer pageSize, String keyword, String order) {
        PageHelper.startPage(page, pageSize);
        // 2.1 构造查询条件
        // QueryWrapper queryWrapper = new QueryWrapper();//条件构造器，不能直接赋值对象
        //如QueryWrapper<Good> warpper = new QueryWrapper<>(good);会导致模糊查询失效
        // QueryWrapper<Model> queryWrapper = new QueryWrapper<>();
        // queryWrapper.like(StringUtils.isNotBlank(keyword), "title", keyword);
        // queryWrapper.like(StringUtils.isNotBlank(keyword), "advertisement", keyword);
        // 2.2 指定排序规则，按照更新时间倒序
        // queryWrapper.orderByDesc("create_time");
        // 2.3 调用查询方法
        // List<Model> models = modelMapper.selectList(queryWrapper);
        List<Model> models = modelMapper.selectModelByKeywordOrder(keyword, order);
        // 2.4 封装分页结果
        return new PageInfo<Model>(models);
    }

    @Override
    public PageInfo<Model> findPageByKeyword(Integer page, Integer pageSize, String keyword) {
        PageHelper.startPage(page, pageSize);

        List<Model> models = modelMapper.selectModelByKeywordOrder(keyword, "create_time");

        return new PageInfo<Model>(models);
    }

    @Override
    public PageInfo<Model> findPageByCategoryIdOrder(Integer page, Integer pageSize, String categoryId, String order) {
        PageHelper.startPage(page, pageSize);
        List<Model> models = modelMapper.selectModelByCategoryIdOrder(categoryId, order);
        return new PageInfo<Model>(models);
    }

    @Override
    public PageInfo<ArticleShowInfo> findPageArticleByKeywordOrder(Integer page, Integer pageSize, String keyword, String order) {
        PageHelper.startPage(page, pageSize);
        List<ArticleShowInfo> articleShowInfos = searchMapper.selectArticleByKeywordOrder(keyword, order);
        return new PageInfo<ArticleShowInfo>(articleShowInfos);
    }

    @Override
    public PageInfo<ArticleShowInfo> findPageArticleByCategoryIdOrder(Integer page, Integer pageSize, String keyword, String order) {
        PageHelper.startPage(page, pageSize);
        List<ArticleShowInfo> articleShowInfos = searchMapper.selectArticleByCategoryIdOrder(keyword, order);
        return new PageInfo<ArticleShowInfo>(articleShowInfos);
    }

    @Override
    public MyPageInfo<ModelMapping> search(String keyword, int from, int pageSize) throws IOException {
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyword, "title", "advertisement", "categoryName");
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field(new HighlightBuilder.Field("title"))
                .field(new HighlightBuilder.Field("advertisement"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(queryBuilder)
                .highlighter(highlightBuilder)
                .from(from)
                .size(pageSize);

        SearchRequest searchRequest = new SearchRequest()
                .indices("models")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<ModelMapping> modelMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            System.out.println(hit);
            // System.out.println(hit);
            Map<String, Object> sourceMap = hit.getSourceAsMap();
            // 获取高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField titleHighlightField = highlightFields.get("title");
            HighlightField advertisementHighlightField = highlightFields.get("advertisement");

            // TODO 异常处理
            String id = sourceMap.get("id").toString();
            String title = null;
            String advertisement = null;
            if(titleHighlightField == null) {
                title = sourceMap.get("title") == null ? null : sourceMap.get("title").toString();
            }else {
                title = titleHighlightField.getFragments()[0].toString();
            }
            if(advertisementHighlightField == null) {
                advertisement = sourceMap.get("advertisement") == null ? null : sourceMap.get("advertisement").toString();
            }else {
                advertisement = advertisementHighlightField.getFragments()[0].toString();
            }
            String categoryId = sourceMap.get("categoryId") == null ? null : sourceMap.get("categoryId").toString();
            String categoryName = sourceMap.get("categoryName") == null ? null : sourceMap.get("categoryName").toString();
            int starCounts = sourceMap.get("starCounts") == null ? 0 : Integer.parseInt(sourceMap.get("starCounts").toString());
            double lowPrice = sourceMap.get("lowPrice") == null ? 0 : Double.parseDouble(sourceMap.get("lowPrice").toString());
            String coverImgUrl = sourceMap.get("coverImgUrl") == null ? null : sourceMap.get("coverImgUrl").toString();
            String sellerId =  sourceMap.get("sellerId") == null? null : sourceMap.get("sellerId").toString();

            Instant instant = Instant.parse(sourceMap.get("createTime").toString());
            Date createTime = new Date();
            if(instant != null) {
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
        // 封装分页结果
        MyPageInfo<ModelMapping> pageInfo = new MyPageInfo<>();
        pageInfo.setPageNum(from / pageSize + 1);
        pageInfo.setTotal(searchResponse.getHits().getTotalHits().value);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) Math.ceil((double) pageInfo.getTotal() / pageInfo.getPageSize()));
        pageInfo.setList(modelMappings);
        return pageInfo;
    }

    // builder.field("id", this.getId());
    //             builder.field("title", this.getTitle());
    //             builder.field("advertisement", this.getAdvertisement());
    //             builder.field("categoryId", this.getCategoryId());
    //             builder.field("categoryName", this.getCategoryName());
    //             builder.field("starCounts", this.getStarCounts());
    //             builder.field("lowPrice", this.getLowPrice());
    //             builder.field("coverImgUrl", this.getCoverImgUrl());
    //             builder.field("sellerId", this.getSellerId());
    //             builder.field("createTime", this.getCreateTime());
}
