package com.lrz.eshop.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 授权用户信息类
 * @author 天天
 * @create 2023/1/21 1:15
 * @description
 */
@ApiModel(value = "授权用户信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserDto {
    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "临时登录凭证")
    private String code;

    @ApiModelProperty(value = "邮箱")
    private String email ;
}
