package com.lrz.eshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.chat.MessageContent;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/4/13 22:44
 * @description
 */
@Repository
public interface MessageContentMapper extends BaseMapper<MessageContent> {

    @Select("select * from message_content where message_id = #{messageId} order by seq asc")
    List<MessageContent> selectByMessageId(Long messageId);

}
