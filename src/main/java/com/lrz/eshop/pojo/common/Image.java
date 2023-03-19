package com.lrz.eshop.pojo.common;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * table name:  image
 * @author 天天  
 * @create 2023/1/19 17:18  
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("image")
public class Image {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    private Short type;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long foreignId;
    private String imgUrl;

    private int seq;

    @TableField(exist = false)
    private String hrefUrl;

    @Version
    @TableField(value = "version", fill = FieldFill.INSERT)
    private int version;

    /* public Image(Short type, Long foreignId, String imgUrl, int seq) {
        this.type = type;
        this.foreignId = foreignId;
        this.imgUrl = imgUrl;
        this.seq = seq;
    } */
}
