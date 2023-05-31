package com.lrz.eshop.service;

/**
 * @author 天天
 * @create 2023/3/3 14:31
 * @description
 */

import com.github.pagehelper.PageInfo;
import com.lrz.eshop.common.page.MyPageInfo;
import com.lrz.eshop.elasticsearch.ArticleMapping;
import com.lrz.eshop.elasticsearch.ModelMapping;
import com.lrz.eshop.pojo.article.ArticleShowInfo;
import com.lrz.eshop.pojo.product.Model;

import java.io.IOException;
import java.util.List;

public interface SearchService {
    PageInfo<Model> findPageByKeywordOrder(Integer page, Integer pageSize, String keyword, String order);

    PageInfo<Model> findPageByKeyword(Integer page, Integer pageSize, String keyword);

    PageInfo<Model> findPageByCategoryIdOrder(Integer page, Integer pageSize, String categoryId, String order);

    // 文章搜索
    PageInfo<ArticleShowInfo> findPageArticleByKeywordOrder(Integer page, Integer pageSize, String keyword, String order);

    PageInfo<ArticleShowInfo> findPageArticleByCategoryIdOrder(Integer page, Integer pageSize, String categoryId, String order);

    /**
     * 使用ES搜索商品
     * @param keyword
     * @param from
     * @param pageSize
     * @return
     */
    MyPageInfo<ModelMapping> search(String keyword, int from, int pageSize) throws IOException;

    MyPageInfo<ModelMapping> searchByCategoryIdOrder(String categoryId, String order, int from, int pageSize) throws IOException;

    MyPageInfo<ArticleMapping> searchArticle(String keyword, int from, int pageSize) throws IOException;

    MyPageInfo<ArticleMapping> searchHotArticle(int pageSize) throws IOException;

    MyPageInfo<ArticleMapping> searchArticleByCategoryIdOrder(String categoryId, String order, int from, int pageSize) throws IOException;

    MyPageInfo<ModelMapping> searchModelNew(int pageSize) throws IOException;

    MyPageInfo<ModelMapping> searchModelHot(int pageSize) throws IOException;
}
