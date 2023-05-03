package com.lrz.eshop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lrz.eshop.component.ResultMessage;
import lombok.Data;

/**
 * 对websocket消息进行封装
 */
@Data
public class MessageUtils {
    public static String getMessage(ResultMessage resultMsg) {
        // 转换为json对象
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(resultMsg);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
