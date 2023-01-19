package com.lrz.eshop.pojo.chat;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**  
 * table name:  room
 * @author 天天  
 * @create 2023/1/19 17:18  
 * @description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("room")
public class Room {
    @TableId(type = IdType.ASSIGN_ID)
    private Long roomId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long fromId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long toId;
    private int cnt;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;

    public Room(Long fromId, Long toId, int cnt) {
        this.fromId = fromId;
        this.toId = toId;
        this.cnt = cnt;
    }
}
