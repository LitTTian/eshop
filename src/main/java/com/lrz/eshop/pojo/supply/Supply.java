package com.lrz.eshop.pojo.supply;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * table name:  supply
 * @TableId 自动生成id
 * @JsonSerialize 防止Long id精度丢失
 */
@TableName("supply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supply {
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String sellerName;
    private String title;
    private String mainImgUrl;
    private Float price;
    private Short category;
    private String region;
    private Boolean delivery;
    private Boolean takeSelf;
    private String description;
    private Integer wantCnt;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
}
