package com.lrz.eshop.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lrz.eshop.pojo.chat.Room;
import com.lrz.eshop.pojo.chat.UserInRoom;
import com.lrz.eshop.pojo.user.UserSocialInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 天天
 * @create 2023/2/26 14:40
 * @description
 */
@Repository
public interface UserInRoomMapper extends BaseMapper<UserInRoom> {


    /**
     * 获得所有会话列表
     * @param userId
     * @return
     */
    @Select("select * from user_in_room where user_id = #{userId}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "roomId", column = "room_id"),
            @Result(property = "room", column = "room_id", javaType = Room.class,
                    one = @One(select = "com.lrz.eshop.mapper.chat.RoomMapper.selectById")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "friendIds", column = "{roomId = room_id, userId = user_id}", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.user.UserInRoomMapper.selectFriendIdsByUserIdAndRoomId")
            ),
            @Result(property = "friends", column = "{roomId = room_id, userId = user_id}", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.user.UserInRoomMapper.selectFriendsByUserIdAndRoomId")
            ),
    })
    List<UserInRoom> selectByUserId(String userId);


    /**
     * 根据用户id查询私聊的room信息
     * @param userId
     * @return
     */
    // select * from (select * from user_in_room where user_id = 70260777) as t1 join room where t1.room_id = room.id and room.type = 1
    @Select("select * from (select * from user_in_room where user_id = #{userId}) as t1 join room where t1.room_id = room.id and room.type = 1")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "roomId", column = "room_id"),
            @Result(property = "room", column = "room_id", javaType = Room.class,
                    one = @One(select = "com.lrz.eshop.mapper.chat.RoomMapper.selectById")
            ),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "friendIds", column = "{roomId = room_id, userId = user_id}", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.user.UserInRoomMapper.selectFriendIdsByUserIdAndRoomId")
            ),
            @Result(property = "friends", column = "{roomId = room_id, userId = user_id}", javaType = List.class,
                    many = @Many(select = "com.lrz.eshop.mapper.user.UserInRoomMapper.selectFriendsByUserIdAndRoomId")
            ),
    })
    List<UserInRoom> selectFriendsInRoomByUserId(String userId);

    @Select("select user_id from user_in_room where room_id = #{roomId} and user_id != #{userId}")
    List<String> selectFriendIdsByUserIdAndRoomId(@Param("roomId") String roomId, @Param("userId") String userId);

    // select id,nickname,avatar_url from
    //     (select user_id from user_in_room where user_id != 70260777 and room_id = 22000001) as t1
    //         left join user on t1.user_id = user.id
    @Select("select id,nickname,avatar_url from (select user_id from user_in_room where room_id = #{roomId} and user_id != #{userId}) as t1 join user on t1.user_id = user.id")
    // @Results({
    //         @Result(column = "user_id", javaType = UserSocialInfo.class,
    //                 one = @One(select = "com.lrz.eshop.mapper.user.UserInfoMapper.getUserSocialInfo")),
    // })
    List<UserSocialInfo> selectFriendsByUserIdAndRoomId(@Param("roomId") String roomId, @Param("userId") String userId);


    @Select("select * from user_in_room where room_id = #{roomId}")
    List<UserInRoom> selectByRoomId(String roomId);

    // select * from user_in_room as t1 join user_in_room as t2 on t1.room_id = t2.room_id and t1.user_id = 70260777 and t2.user_id = 366602633 join room on t1.room_id = room.id and room.type = 1
    @Select("select room.id from user_in_room as t1 join user_in_room as t2 on t1.room_id = t2.room_id and t1.user_id = #{userId1} and t2.user_id = #{userId2} join room on t1.room_id = room.id and room.type = 1")
    String hasPrivateRoom(String userId1, String userId2);




}
