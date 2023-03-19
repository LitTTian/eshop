package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.chat.Message;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**  
 *
 * @author 天天  
 * @create 2023/1/19 17:17
 * @description    
 */
@Repository
public interface MessageMapper extends BaseMapper<Message> {

    /**
     * 根据房间id查询消息（最新优先）
     * @param roomId
     * @return
     */
    @Select("select * from message where room_id = #{roomId} order by create_time desc")
    List<Message> selectByRoomId(String roomId);

}
