package com.lrz.eshop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lrz.eshop.pojo.chat.ResultMessage;
import lombok.Data;

/**
 * 对消息进行封装
 */
@Data
public class MessageUtils {
    public static String getMessage(String type, boolean fromNew, String id, Object result) {
        ResultMessage resultMsg = new ResultMessage();
        resultMsg.setResult(result);
        resultMsg.setFromNew(fromNew);
        resultMsg.setType(type);
        if(id != null) {
            resultMsg.setId(id);
        }
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
