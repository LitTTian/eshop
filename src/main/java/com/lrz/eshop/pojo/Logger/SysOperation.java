package com.lrz.eshop.pojo.Logger;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 天天
 * @create 2023/4/26 14:16
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_operation")
public class SysOperation {
    @TableId(type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String module;
    private String operation;
    private String params;
    private String ip;
    private String executeTime;
    @TableField(fill = FieldFill.INSERT)
    Date createTime;
}
