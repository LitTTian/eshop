package com.lrz.eshop.common.aop;

import java.lang.annotation.*;

/**
 * @author 天天
 * @create 2023/4/26 10:38
 * @description
 */

@Target({ElementType.METHOD}) // ElementType.METHOD表示该注解能用于方法上,ElementType.TYPE表示该注解能用于类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DBLoggerAnnotation {

    String module() default "";
    String operation() default "";

    String params() default "";

    // String foreignId() default "";

}
