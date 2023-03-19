package com.lrz.eshop.service;

import com.lrz.eshop.pojo.chat.Message;
import com.lrz.eshop.pojo.chat.ResultMessage;
import com.lrz.eshop.pojo.chat.Room;
import com.lrz.eshop.pojo.chat.UserInRoom;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 天天
 * @create 2023/3/10 21:00
 * @description
 */
public interface MessageService {

    List<UserInRoom> getPrivateChat(String userId);

    List<Message> getRoomMessage(String roomId);

    Room contactSeller(String buyerId, String sellerId);



}
