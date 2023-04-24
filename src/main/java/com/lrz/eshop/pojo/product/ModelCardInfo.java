package com.lrz.eshop.pojo.product;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 天天
 * @create 2023/4/22 13:59
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelCardInfo {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private String title;

    @TableField(exist = false)
    private double lowPrice;

    @TableField(exist = false)
    private String coverImgUrl;

}
