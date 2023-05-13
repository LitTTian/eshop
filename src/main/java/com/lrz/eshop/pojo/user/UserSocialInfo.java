package com.lrz.eshop.pojo.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户的社交信息
 * @author 天天
 * @create 2023/3/15 15:27
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSocialInfo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String signature;
    private String nickname;
    private String avatarUrl;
    private Date createTime;

}
