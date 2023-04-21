package com.lrz.eshop.pojo.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天天
 * @create 2023/4/19 15:08
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private UserSocialInfo userSocialInfo;
    private UserSellInfo userSellInfo;
    private UserCommunityInfo userCommunityInfo;
}
