package com.lrz.eshop.service.impl;

import com.lrz.eshop.mapper.MessageMapper;
import com.lrz.eshop.mapper.RoomMapper;
import com.lrz.eshop.mapper.UserInRoomMapper;
import com.lrz.eshop.pojo.chat.Message;
import com.lrz.eshop.pojo.chat.ResultMessage;
import com.lrz.eshop.pojo.chat.Room;
import com.lrz.eshop.pojo.chat.UserInRoom;
import com.lrz.eshop.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Messager;
import javax.websocket.server.ServerEndpoint;
import java.util.List;

/**
 * @author 天天
 * @create 2023/3/10 21:01
 * @description
 */
@Service
public class MessageServiceImpl implements MessageService {

    private static final String HELLO_MESSAGE = "我看上你的商品了，可以便宜点卖不？";

    @Autowired
    private UserInRoomMapper userInRoomMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<UserInRoom> getPrivateChat(String userId) {
        return userInRoomMapper.selectPrivateChatByUserId(userId);
    }

    @Override
    public List<Message> getRoomMessage(String roomId) {
        return messageMapper.selectByRoomId(roomId);
    }

    @Override
    public Room contactSeller(String buyerId, String sellerId) {
        // 判断两人是否已经存在私聊聊天室
        String roomId = userInRoomMapper.hasPrivateRoom(buyerId, sellerId);
        // boolean newRoom = false;
        if(roomId == null) {
            // 两人不存在私聊聊天室
            // 创建私聊房间
            Room room = new Room();
            room.setType((short) 1);
            roomMapper.insert(room);
            Long newRoomId = room.getId();
            if(newRoomId == null) {
                // 建立房间失败
                return null;
            }
            // newRoom = true;
            UserInRoom userInroom1 = new UserInRoom();
            userInroom1.setRoomId(newRoomId);
            userInroom1.setUserId(Long.valueOf(buyerId));
            userInRoomMapper.insert(userInroom1);
            UserInRoom userInroom2 = new UserInRoom();
            userInroom2.setRoomId(newRoomId);
            userInroom2.setUserId(Long.valueOf(sellerId));
            userInRoomMapper.insert(userInroom2);
            // 发送初始消息
            Message message = new Message();
            message.setRoomId(newRoomId);
            message.setUserId(Long.valueOf(buyerId));
            message.setContent(HELLO_MESSAGE);
            messageMapper.insert(message);
            // 返回新的房间号
            roomId = String.valueOf(newRoomId);
        }
        Room room = roomMapper.selectById(roomId);
        return room;
    }
}
