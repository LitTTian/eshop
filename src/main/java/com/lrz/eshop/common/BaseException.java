package com.lrz.eshop.common;

/**
 * @author 天天
 * @create 2023/3/7 3:18
 * @description
 */
public class BaseException extends RuntimeException {
    /**
     * 参考
     */
    private String code;
    /**
     * 错误信息
     */
    private String errorMessage;


    public BaseException(String code) {
        this.code = code;
        this.errorMessage = "";
    }

    public BaseException(String code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;

    }

    public BaseException(String code, String errorMessage, Throwable e) {
        super(errorMessage, e);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    /**
     * 创建一个系统配置异常方法
     * <p>未找到相关服务请求</p>
     *
     * @param errorMessage 错误信息
     * @return 实例
     */
    public static BaseException createSysActionNotFound(String errorMessage) {
        return new BaseException(ConstantResultCode.ERROR_SYS_ACTION_NOT_FOUND, errorMessage);
    }

    /**
     * 创建一个请求参数异常方法
     * <p>参数格式不匹配</p>
     *
     * @param errorMessage 错误信息
     * @return 实例
     */
    public static BaseException createClientParams(String errorMessage) {
        return new BaseException(ConstantResultCode.ERROR_CLIENT_PARAMETER_FORMAT_NOT_MATCH, errorMessage);
    }

    /**
     * 创建一个系统配置异常方法
     * <p>系统转换数据失败</p>
     *
     * @param errorMessage 错误信息
     * @param e            异常信息
     * @return 实例
     */
    public static BaseException createSysDataConvert(String errorMessage, Exception e) {
        return new BaseException(ConstantResultCode.ERROR_SYS_FAILED_DATA_CONVERT, errorMessage, e);
    }

    /**
     * 创建一个系统数据结构异常方法
     * <p>相关数据缺失</p>
     * <p>系统不可能出行的数据错误，一般由手工修改导致的错误</p>
     *
     * @param errorMessage 错误相关信息
     * @return 异常实例
     */
    public static BaseException createSysDataStructure(String errorMessage) {
        return new BaseException(ConstantResultCode.ERROR_SYS_DATA_STRUCTURE, errorMessage);
    }


    /**
     * 创建一个系统数据结构异常方法
     * <p>获取系统配置参数异常</p>
     *
     * @param errorMessage 错误相关信息
     * @return 异常实例
     */
    public static BaseException createSysConf(String errorMessage) {
        return new BaseException(ConstantResultCode.ERROR_SYS_CONF, errorMessage);
    }

    /**
     * 系统代码逻辑异常
     * <p>1.出现不符合设计逻辑时抛出异常</p>
     *
     * @param errorMessage 错误相关信息
     * @return 异常实例
     */
    public static BaseException createSysCode(String errorMessage) {
        return new BaseException(ConstantResultCode.ERROR_SYS_CODE, errorMessage);
    }

    /**
     * 远程调用反馈失败
     *
     * @param errorMessage 错误相关信息
     * @return 异常实例
     */
    public static BaseException createRemote(String errorMessage) {
        return new BaseException(ConstantResultCode.ERROR_REMOTE, errorMessage);
    }

    /**
     * 远程调用异常
     *
     * @param errorMessage 错误相关信息
     * @param e            异常信息
     * @return 异常实例
     */
    public static BaseException createRemote(String errorMessage, Exception e) {
        return new BaseException(ConstantResultCode.ERROR_REMOTE_MIDDLEWARE, errorMessage, e);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
