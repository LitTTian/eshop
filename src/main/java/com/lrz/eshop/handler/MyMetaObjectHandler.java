package com.lrz.eshop.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * MyBatisPlus字段自动填充
 * @author 天天
 * @create 2023/1/19 16:40
 * @description
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时的自动填充策略
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject,"cumulativeScore", Integer.class, 0);
        this.strictInsertFill(metaObject,"creditScore", Short.class, (short)100);
        this.strictInsertFill(metaObject,"balance", Float.class, (float)0f);
        this.strictInsertFill(metaObject,"isSeller", Boolean.class, false);
        this.strictInsertFill(metaObject, "version", Integer.class, 1);
        this.strictInsertFill(metaObject, "state", Short.class, (short)1);
        // 文章浏览量
        this.strictInsertFill(metaObject, "watches", Integer.class, 0);
        // model是否被删除
        this.strictInsertFill(metaObject, "deleted", Boolean.class, false);
        this.strictInsertFill(metaObject, "type", Byte.class, (byte)1);
    }

    /**
     * 更新时的自动填充策略
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // LocalDateTime::now, LocalDateTime.class
        // this.setFieldValByName("updateTime", Calendar.getInstance(Locale.CHINA).getTime(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    // public static void main(String[] args) {
    //     System.out.println(new Date());
    // }
}
