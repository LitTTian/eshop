package com.lrz.eshop.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lrz.eshop.pojo.product.Model;
import com.lrz.eshop.pojo.product.Product;
import com.lrz.eshop.pojo.trade.Trade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Result;

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
    @TableId(type = IdType.AUTO)
//    @JsonSerialize(using = ToStringSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String avatarUrl;
    @TableField(fill = FieldFill.INSERT)
    private short creditScore;
    @TableField(fill = FieldFill.INSERT)
    private Integer cumulativeScore;
    private float balance; //余额

    private boolean isSeller;
    private Long shopId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;

    @TableField(exist = false)
    private List<Model> models;

    @TableField(exist = false)
    private List<Trade> buys;
    @TableField(exist = false)
    private List<Trade> sells;

    @TableField(exist = false)
    private String token;

}
