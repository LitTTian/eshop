package com.lrz.eshop.elasticsearch;

import org.springframework.data.elasticsearch.annotations.FieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author 天天
 * @create 2023/5/11 22:55
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ElasticsearchProperty {
    FieldType type() default FieldType.Auto;
    boolean index() default true;
    String analyzer() default "";
    String searchAnalyzer() default "";
    String[] ignoreFields() default {};
    String[] fields() default {};
    String format() default "";
    boolean store() default false;
    boolean fielddata() default false;
    String nullValue() default "";
    String copyTo() default "";
}
