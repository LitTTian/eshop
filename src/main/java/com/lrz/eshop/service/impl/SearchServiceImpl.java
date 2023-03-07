package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrz.eshop.mapper.ModelMapper;
import com.lrz.eshop.pojo.User;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/3 14:37
 * @description
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    ModelMapper modelMapper;
    @Override
    public PageInfo<Model> findPageByKeywordOrder(Integer page, Integer size, String keyword, String order) {
        PageHelper.startPage(page, size);
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
    public PageInfo<Model> findPageByKeyword(Integer page, Integer size, String keyword) {
        PageHelper.startPage(page, size);

        List<Model> models = modelMapper.selectModelByKeywordOrder(keyword, "create_time");

        return new PageInfo<Model>(models);
    }
}
