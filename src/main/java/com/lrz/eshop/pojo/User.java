package com.lrz.eshop.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.supply.Sell;
import com.lrz.eshop.pojo.trade.Trade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * table name:  user
 * @author 天天
 * @create 2023/1/19 2:52
 * @description
 */
@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.ASSIGN_ID)
//    @JsonSerialize(using = ToStringSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String username;
    private String pwd;
    @TableField(fill = FieldFill.INSERT)
    private short creditScore;
    @TableField(fill = FieldFill.INSERT)
    private Integer cumulativeScore;
    private Integer schoolId;
    // avatarUrl
    private String avatarUrl;
    private Long balance; //余额
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;

    @TableField(exist = false)
    private List<Trade> trades;
    @TableField(exist = false)
    private List<Sell> sells;
}