package com.lrz.eshop.common.webapi;

/**
 * 枚举了一些常用API操作码
 * @author 天天
 * @create 2023/1/19 3:03
 * @description
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    NOTFOUND(404, "未找到相关资源"),
    VALIDATE_FAILED(506, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),
    Authentication_Timeout(419, "认证超时"),
    LoginFailed(444, "登录失败"),
    UserNotExist(445, "用户不存在"),
    UsernameAlreadyExist(446, "用户名已存在"),
    EmailAlreadyExist(447, "邮箱已存在"),
    TokenIsBlocked(448, "token已过期"),;
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
