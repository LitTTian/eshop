package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.chat.Message;
import com.lrz.eshop.pojo.chat.MessageContent;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
    @Results({
        @Result(property = "messageContents", column = "id", javaType = List.class,
                many = @Many(select = "com.lrz.eshop.mapper.MessageContentMapper.selectByMessageId")
        ),
        @Result(property = "user", column = "user_id", javaType = UserSocialInfo.class,
                many = @Many(select = "com.lrz.eshop.mapper.UserMapper.selectSocialInfoById")
        ),
    })
    List<Message> selectByRoomId(String roomId);

}
