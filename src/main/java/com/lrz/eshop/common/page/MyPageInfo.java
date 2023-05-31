package com.lrz.eshop.common.page;

import lombok.Data;

import java.util.List;

/**
 * 分页封装
 * @author 天天
 * @create 2023/5/12 4:40
 * @description
 */
@Data
public class MyPageInfo<T> {
    int pageNum; // 当前页
    int pageSize; // 每页的数量
    int pages; // 总页数
    long total; // 总记录数
    List<T> list; // 结果集
}
