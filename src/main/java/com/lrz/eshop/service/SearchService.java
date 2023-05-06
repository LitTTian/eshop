package com.lrz.eshop.service;

/**
 * @author 天天
 * @create 2023/3/3 14:31
 * @description
 */

import com.github.pagehelper.PageInfo;
import com.lrz.eshop.pojo.product.Model;

public interface SearchService {
    PageInfo<Model> findPageByKeywordOrder(Integer page, Integer size, String keyword, String order);

    PageInfo<Model> findPageByKeyword(Integer page, Integer size, String keyword);

}
