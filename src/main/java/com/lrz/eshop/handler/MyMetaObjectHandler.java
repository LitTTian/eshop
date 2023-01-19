package com.lrz.eshop.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * MyBatisPlus字段自动填充
 * @author 天天
 * @create 2023/1/19 16:40
 * @description
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入时的自动填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("cumulativeScore", 0, metaObject);
        this.setFieldValByName("creditScore", (short)100, metaObject);
        //        this.setFieldValByName("balance", 100L, metaObject);
    }
    //更新时的自动填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}
