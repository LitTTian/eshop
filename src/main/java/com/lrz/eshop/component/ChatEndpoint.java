package com.lrz.eshop.component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lrz.eshop.config.GetHttpSessionConfigurator;
import com.lrz.eshop.mapper.MessageMapper;
import com.lrz.eshop.mapper.RoomMapper;
import com.lrz.eshop.mapper.UserInRoomMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.chat.Message;
import com.lrz.eshop.pojo.chat.ReceiveMessage;
import com.lrz.eshop.pojo.chat.Room;
import com.lrz.eshop.pojo.chat.UserInRoom;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 天天
 * @create 2023/3/10 17:04
 * @description 每个客户端都有一个ChatEndpoint对象，每个对象都是独立的，
 * 可以获取其中的session对象，通过session对象可以向客户端发送消息
 */


@ServerEndpoint(value = "/chat", configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndpoint {

    // 定义一个静态的map，用来存放每个客户端对应的ChatEndpoint对象
    // 键可以使用userid标识每个客户端
    private static Map<String, ChatEndpoint> onlineUsers = new ConcurrentHashMap<>();


    // 声明session对象，通过该对象可以发送消息给指定的客户端
    private Session session;
    // 声明httpSession对象，通过该对象可以获取当前用户的信息
    private HttpSession httpSession;


    private static UserMapper userMapper;
    private static RoomMapper roomMapper;
    private static MessageMapper messageMapper;
    private static UserInRoomMapper userInRoomMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        ChatEndpoint.userMapper = userMapper;
    }

    @Autowired
    public void setRoomMapper(RoomMapper roomMapper) {
        ChatEndpoint.roomMapper = roomMapper;
    }

    @Autowired
    public void setMessageMapper(MessageMapper messageMapper) {
        ChatEndpoint.messageMapper = messageMapper;
    }

    @Autowired
    public void UserInRoomMapper(UserInRoomMapper userInRoomMapper) {
        ChatEndpoint.userInRoomMapper = userInRoomMapper;
    }


    @OnOpen // 当连接建立时触发
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        // this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        // 获取httpSession对象
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        this.httpSession = httpSession;
        // 从httpSession中获取当前用户的id
        String id = (String) httpSession.getAttribute("id");
        if(id == null) return;
        System.out.println("websocket-getAttribute-id:" + id);
        // 将当前对象存入map中
        // onlineUsers.put(id, this);
        onlineUsers.put((String) httpSession.getAttribute("id"), this);

        // 查询结果是Map的列表，每个map表示一个user，有username和头像url两个属性
        // List<Map<String, String>> userList = new ArrayList<>();


        // 将当前在线用户的id推送给所有客户端
        // 1.获取消息
        // String message = MessageUtils.getMessage(true, null, getIds());
        // String message = "";

        // 2.调用方法进行系统消息的推送
        // broadcastAllUsers(message);

        List<UserInRoom> userInRooms = userInRoomMapper.selectPrivateChatByUserId(id);
        String resultMessage = MessageUtils.getMessage("userInRooms", true, null, userInRooms);
        try {
            onlineUsers.get(id).session.getBasicRemote().sendText(resultMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("连接成功");
    }

    /**
     * 系统消息的推送
     * @param message
     */
    private void broadcastAllUsers(String message) {
        try {
            Set<String> ids = getIds();
            for(String id : ids) {
                ChatEndpoint chatEndpoint = onlineUsers.get(id);
                chatEndpoint.session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取当前在线用户的id
     * @return
     */
    private Set<String> getIds() {
        return onlineUsers.keySet();
    }

    @OnMessage // 当收到客户端消息时触发
    public void onMessage(String message, Session session) {
        System.out.println("收到消息：" + message);
        // message从String转换为Message的对象
        try {
            ObjectMapper mapper = new ObjectMapper();
            ReceiveMessage mess = mapper.readValue(message, ReceiveMessage.class);
            String content = mess.getContent();
            // 接收者的id
            String toId = mess.getToId();
            String roomId = mess.getRoomId();
            // 你要是真不想发就别发了
            if(toId == null && roomId == null) return;
            // String roomId = mess.getRoomId();
            // 查找接收者的id
            System.out.println("接收者的id" + toId);
            String fromId = (String) httpSession.getAttribute("id");
            System.out.println("content: " + content + ", id: " + fromId);
            // 写入数据库
            // 判断是否已有这两个人组成的房间
            boolean newRoom = false;
            if(roomId == null) {
                roomId = userInRoomMapper.hasPrivateRoom(fromId, toId);
            }
            if(roomId == null) {
                // 创建房间
                Room room = new Room();
                room.setType((short) 1);
                roomMapper.insert(room);
                Long newRoomId = room.getId();
                if (newRoomId == null) {
                    return;
                }
                newRoom = true;
                System.out.println("创建房间成功!" + room.getId());
                UserInRoom userInroom1 = new UserInRoom();
                userInroom1.setRoomId(newRoomId);
                userInroom1.setUserId(Long.valueOf(fromId));
                userInRoomMapper.insert(userInroom1);
                UserInRoom userInroom2 = new UserInRoom();
                userInroom2.setRoomId(newRoomId);
                userInroom2.setUserId(Long.valueOf(toId));
                userInRoomMapper.insert(userInroom2);
                roomId = String.valueOf(newRoomId);
            }
            Message newMessage = new Message();
            newMessage.setUserId(Long.valueOf(fromId));
            newMessage.setRoomId(Long.valueOf(roomId));
            newMessage.setContent(content);

            // 将要发送的数据
            // 数据携带的是发送者用户名，而不是id
            // User fromUser = userMapper.selectById(fromId);
            String resultMessage = MessageUtils.getMessage("chat", newRoom, roomId, content);
            messageMapper.insert(newMessage);
            System.out.println(resultMessage);
            // 发送到目标用户的 ChatEndpoint 对象
            // 注意，如果对方许久未登录，那么这个session对象不存在；如果对方登陆了刚刚推出了，这个session对象存在但处于断开状态
            if(toId != null) {
                if (onlineUsers.get(toId) != null && onlineUsers.get(toId).session.isOpen()) {
                    // 发送消息
                    // m.setSeen(true);
                    onlineUsers.get(toId).session.getBasicRemote().sendText(resultMessage);
                } else {
                    // m.setSeen(false);
                    System.out.println("对方离线");
                }
            }else {
                // 查询房间中的其他人
                // 群聊的关键！！
                List<String> friendIds = userInRoomMapper.selectFriendIdsByUserIdAndRoomId(roomId, fromId);
                for(String friendId: friendIds) {
                    if(friendId != null) {
                        if (onlineUsers.get(friendId) != null && onlineUsers.get(friendId).session.isOpen()) {
                            // 发送消息
                            // m.setSeen(true);
                            onlineUsers.get(friendId).session.getBasicRemote().sendText(resultMessage);
                        } else {
                            // m.setSeen(false);
                            System.out.println("对方离线");
                        }
                    }
                }
/*                 List<UserInRoom> userInRooms = userInRoomMapper.selectByRoomId(roomId);
                for(UserInRoom userInRoom: userInRooms) {
                    if(userInRoom.getUserId() != null) {
                        if (onlineUsers.get(toId) != null && onlineUsers.get(toId).session.isOpen()) {
                            // 发送消息
                            // m.setSeen(true);
                            onlineUsers.get(toId).session.getBasicRemote().sendText(resultMessage);
                        } else {
                            // m.setSeen(false);
                            System.out.println("对方离线");
                        }
                    }
                } */
            }

            // System.out.println("the message to insert: " + m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose // 当连接关闭时触发
    public void onClose() {
        System.out.println("连接关闭");
    }

    @OnError // 当连接发生错误时触发
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }




}
