package com.lrz.eshop.common.webapi;

/**  
 * 封装API的错误码
 * @author 天天  
 * @create 2023/1/19 3:03  
 * @description    
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
