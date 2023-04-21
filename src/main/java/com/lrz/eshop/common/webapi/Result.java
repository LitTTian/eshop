package com.lrz.eshop.common.webapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回对象
 * @author 天天
 * @create 2023/1/19 3:03
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private long code;
    private String message;
    private T result;

    public static <T> Result<T> createResult(long code, String message, T result) {
        return new Result<T>(code, message, result);
    }


    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败
     * @param errorCode 错误码
     */
    public static <T> Result<T> failed(IErrorCode errorCode) {
        return new Result<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 操作失败
     * @param errorCode 错误码
     * @param data 错误返回数据
     */
    public static <T> Result<T> failed(IErrorCode errorCode, T data) {
        return new Result<T>(errorCode.getCode(), errorCode.getMessage(), data);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     * @param data 错误返回数据
     */
    public static <T> Result<T> failed(String message, T data) {
        return new Result<T>(ResultCode.FAILED.getCode(), message, data);
    }

    /**
     * 失败返回结果 500
     */
    public static <T> Result<T> operateFailed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> Result<T> notFound() {
        return failed(ResultCode.NOTFOUND);
    }


    /**
     * 参数验证失败返回结果
     */
    public static <T> Result<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> Result<T> validateFailed(String message) {
        return new Result<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> Result<T> unauthorized(T data) {
        return new Result<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> Result<T> forbidden(T data) {
        return new Result<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }


}
