package com.lrz.eshop.pojo.supply;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * table name:  star
 * @author 天天
 * @create 2023/1/19 17:18
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("star")
public class Star {
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long supplyId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @Version
    private int version;
}
