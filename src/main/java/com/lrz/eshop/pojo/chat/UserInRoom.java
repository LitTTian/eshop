package com.lrz.eshop.pojo.chat;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 14:33
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_in_room")
public class UserInRoom {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roomId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(exist = false)
    private Room room;

    @TableField(exist = false)
    private List<String> friendIds;

    @TableField(exist = false)
    private List<UserSocialInfo> friends;

}
