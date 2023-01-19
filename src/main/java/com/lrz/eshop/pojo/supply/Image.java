package com.lrz.eshop.pojo.supply;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**  
 * table name:  image
 * @author 天天  
 * @create 2023/1/19 17:18  
 * @description
 */
@TableName("supply_image")
@Data
public class Image {
    @TableId(type = IdType.ASSIGN_ID)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long supplyId;
    String url;

    public Image(Long supplyId, String url) {
        this.supplyId = supplyId;
        this.url = url;
    }
}
