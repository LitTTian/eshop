package com.lrz.eshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.eshop.common.page.MyPageInfo;
import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.elasticsearch.ArticleMapping;
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

    // ElasticSearch搜索
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
            // System.out.println(hit);
            // Map<String, Object> sourceMap = hit.getSourceAsMap();
            ModelMapping modelMapping = hitToModelMapping(hit);
            // 获取高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField titleHighlightField = highlightFields.get("title");
            HighlightField advertisementHighlightField = highlightFields.get("advertisement");
            if (titleHighlightField != null) {
                modelMapping.setTitle(titleHighlightField.getFragments()[0].toString());
            }
            if (advertisementHighlightField != null) {
                modelMapping.setAdvertisement(advertisementHighlightField.getFragments()[0].toString());
            }
            modelMappings.add(modelMapping);
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

    @Override
    public MyPageInfo<ModelMapping> searchByCategoryIdOrder(String categoryId, String order, int from, int pageSize) throws IOException {
        QueryBuilder queryBuilder = QueryBuilders.termQuery("categoryId", categoryId);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(queryBuilder)
                .sort(orderConvertor(order), SortOrder.DESC)
                .from(from)
                .size(pageSize);
        SearchRequest searchRequest = new SearchRequest()
                .indices("models")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<ModelMapping> modelMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            // System.out.println(hit);
            // Map<String, Object> sourceMap = hit.getSourceAsMap();
            // 获取高亮字段
            ModelMapping modelMapping = hitToModelMapping(hit);
            modelMappings.add(modelMapping);
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

    @Override
    public MyPageInfo<ArticleMapping> searchArticle(String keyword, int from, int pageSize) throws IOException {
        QueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(keyword, "title", "abstracts", "categoryName");
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field(new HighlightBuilder.Field("title"))
                .field(new HighlightBuilder.Field("abstracts"));
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(queryBuilder)
                .highlighter(highlightBuilder)
                .from(from)
                .size(pageSize);
        SearchRequest searchRequest = new SearchRequest()
                .indices("articles")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        List<ArticleMapping> articleMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            // System.out.println(hit);
            // Map<String, Object> sourceMap = hit.getSourceAsMap();
            // 获取高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField titleHighlightField = highlightFields.get("title");
            HighlightField abstractsHighlightField = highlightFields.get("abstracts");
            ArticleMapping mapping = hitToArticleMapping(hit);
            if(titleHighlightField != null) {
                mapping.setTitle(titleHighlightField.getFragments()[0].toString());
            }
            if(abstractsHighlightField != null) {
                mapping.setAbstracts(abstractsHighlightField.getFragments()[0].toString());
            }
            articleMappings.add(mapping);
        }
        // 封装分页结果
        MyPageInfo<ArticleMapping> pageInfo = new MyPageInfo<>();
        pageInfo.setPageNum(from / pageSize + 1);
        pageInfo.setTotal(searchResponse.getHits().getTotalHits().value);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) Math.ceil((double) pageInfo.getTotal() / pageInfo.getPageSize()));
        pageInfo.setList(articleMappings);
        return pageInfo;
    }

    @Override
    public MyPageInfo<ArticleMapping> searchHotArticle(int pageSize) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                // .query(queryBuilder)
                .sort("watches", SortOrder.DESC)
                .from(0)
                .size(pageSize);
        SearchRequest searchRequest = new SearchRequest()
                .indices("articles")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<ArticleMapping> articleMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            articleMappings.add(hitToArticleMapping(hit));
        }
        MyPageInfo<ArticleMapping> pageInfo = new MyPageInfo<>();
        pageInfo.setPageNum(1);
        pageInfo.setTotal(searchResponse.getHits().getTotalHits().value);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) Math.ceil((double) pageInfo.getTotal() / pageInfo.getPageSize()));
        pageInfo.setList(articleMappings);
        return pageInfo;
    }

    @Override
    public MyPageInfo<ArticleMapping> searchArticleByCategoryIdOrder(String categoryId, String order, int from, int pageSize) throws IOException {
        QueryBuilder queryBuilder = QueryBuilders.termQuery("categoryId", categoryId);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(queryBuilder)
                .sort(orderConvertor(order), SortOrder.DESC)
                .from(from)
                .size(pageSize);
        SearchRequest searchRequest = new SearchRequest()
                .indices("articles")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<ArticleMapping> articleMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            articleMappings.add(hitToArticleMapping(hit));
        }
        MyPageInfo<ArticleMapping> pageInfo = new MyPageInfo<>();
        pageInfo.setPageNum(from / pageSize + 1);
        pageInfo.setTotal(searchResponse.getHits().getTotalHits().value);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) Math.ceil((double) pageInfo.getTotal() / pageInfo.getPageSize()));
        pageInfo.setList(articleMappings);
        return pageInfo;
    }

    @Override
    public MyPageInfo<ModelMapping> searchModelNew(int pageSize) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                // .query(queryBuilder)
                .sort("createTime", SortOrder.DESC)
                .from(0)
                .size(pageSize);
        SearchRequest searchRequest = new SearchRequest()
                .indices("models")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<ModelMapping> modelMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            modelMappings.add(hitToModelMapping(hit));
        }
        MyPageInfo<ModelMapping> pageInfo = new MyPageInfo<>();
        pageInfo.setPageNum(1);
        pageInfo.setTotal(searchResponse.getHits().getTotalHits().value);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) Math.ceil((double) pageInfo.getTotal() / pageInfo.getPageSize()));
        pageInfo.setList(modelMappings);
        return pageInfo;
    }

    @Override
    public MyPageInfo<ModelMapping> searchModelHot(int pageSize) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                // .query(queryBuilder)
                .sort("sellCounts", SortOrder.DESC)
                .from(0)
                .size(pageSize);
        SearchRequest searchRequest = new SearchRequest()
                .indices("models")
                .source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<ModelMapping> modelMappings = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            modelMappings.add(hitToModelMapping(hit));
        }
        MyPageInfo<ModelMapping> pageInfo = new MyPageInfo<>();
        pageInfo.setPageNum(1);
        pageInfo.setTotal(searchResponse.getHits().getTotalHits().value);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPages((int) Math.ceil((double) pageInfo.getTotal() / pageInfo.getPageSize()));
        pageInfo.setList(modelMappings);
        return pageInfo;
    }


    public ModelMapping hitToModelMapping(SearchHit hit) {
        Map<String, Object> sourceMap = hit.getSourceAsMap();
        long id = sourceMap.get("id") == null ? 0 : Long.parseLong(sourceMap.get("id").toString());
        String title = sourceMap.get("title") == null ? null: sourceMap.get("title").toString();
        String advertisement = sourceMap.get("advertisement") == null ? null: sourceMap.get("advertisement").toString();
        long categoryId = sourceMap.get("categoryId") == null ? 0 : Long.parseLong(sourceMap.get("categoryId").toString());
        String categoryName = sourceMap.get("categoryName") == null ? null : sourceMap.get("categoryName").toString();
        int starCounts = sourceMap.get("starCounts") == null ? 0 : Integer.parseInt(sourceMap.get("starCounts").toString());
        int sellCounts = sourceMap.get("sellCounts") == null ? 0 : Integer.parseInt(sourceMap.get("sellCounts").toString());
        double lowPrice = sourceMap.get("lowPrice") == null ? 0 : Double.parseDouble(sourceMap.get("lowPrice").toString());
        String coverImgUrl = sourceMap.get("coverImgUrl") == null ? null : sourceMap.get("coverImgUrl").toString();
        long sellerId = sourceMap.get("sellerId") == null ? 0 : Long.parseLong(sourceMap.get("sellerId").toString());
        Instant instant = Instant.parse(sourceMap.get("createTime").toString());
        Date createTime = new Date();
        if(instant != null) {
            createTime = Date.from(instant);
        }
        return new ModelMapping(id, title, advertisement, categoryId, categoryName, starCounts, sellCounts, lowPrice, coverImgUrl, sellerId, createTime);
    }
    public ArticleMapping hitToArticleMapping(SearchHit hit) {
        Map<String, Object> sourceMap = hit.getSourceAsMap();
        Long id = sourceMap.get("id") == null ? null : Long.parseLong(sourceMap.get("id").toString());
        Long userId = sourceMap.get("userId") == null ? null : Long.parseLong(sourceMap.get("userId").toString());
        String nickname = sourceMap.get("nickname") == null ? null : sourceMap.get("nickname").toString();
        String title = sourceMap.get("title") == null ? null: sourceMap.get("title").toString();
        String abstracts = sourceMap.get("abstracts") == null ? null : sourceMap.get("abstracts").toString();
        Long categoryId = sourceMap.get("categoryId") == null ? null : Long.parseLong(sourceMap.get("categoryId").toString());
        String categoryName = sourceMap.get("categoryName") == null ? null : sourceMap.get("categoryName").toString();
        String coverImageUrl = sourceMap.get("coverImageUrl") == null ? null : sourceMap.get("coverImageUrl").toString();
        int watches = sourceMap.get("watches") == null ? 0 : Integer.parseInt(sourceMap.get("watches").toString());
        int stars = sourceMap.get("stars") == null ? 0 : Integer.parseInt(sourceMap.get("stars").toString());
        int likes = sourceMap.get("likes") == null ? 0 : Integer.parseInt(sourceMap.get("likes").toString());
        int dislikes = sourceMap.get("dislikes") == null ? 0 : Integer.parseInt(sourceMap.get("dislikes").toString());
        Instant instant = Instant.parse(sourceMap.get("createTime").toString());
        Date createTime = new Date();
        if(instant != null) {
            createTime = Date.from(instant);
        }
        return new ArticleMapping(id, userId, nickname, categoryId, categoryName, title, abstracts, coverImageUrl, watches, stars, likes, dislikes, createTime);
    }

    public String orderConvertor(String order) {
        switch (order) {
            case "star_counts":
                return "starCounts";
            case "low_price":
                return "lowPrice";
            case "create_time":
                return "createTime";
            default:
                return "createTime";
        }
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
