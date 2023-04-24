package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.pojo.chat.Message;
import com.lrz.eshop.pojo.chat.Room;
import com.lrz.eshop.pojo.chat.UserInRoom;
import com.lrz.eshop.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户消息控制器
 * @author 天天
 * @create 2023/3/9 15:21
 * @description
 */
@Api(tags = "message-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 获取用户的所有私聊列表
     * @param userId
     * @return
     */
    @ApiOperation("获取私聊列表")
    @PostMapping("/getPrivateChat")
    public Result<?> getPrivateChat(@RequestParam("userId") String userId) {
        List<UserInRoom> friends = messageService.getPrivateChat(userId);
        return Result.success(friends);
    }

    /**
     * 获取指定房间号内的所有消息
     * @param roomId
     * @return
     */
    @ApiOperation("获取房间消息")
    @PostMapping("/getRoomMessage")
    public Result<?> getRoomMessage(@RequestParam("roomId") String roomId) {
        List<Message> messages = messageService.getRoomMessage(roomId);
        return Result.success(messages);
    }

    /**
     * 联系卖家
     * @param buyerId
     * @param sellerId
     * @return
     */
    @ApiOperation("用户联系客服")
    @PostMapping("/contactSeller")
    public Result<?> contactSeller(@RequestParam("buyerId") String buyerId, @RequestParam("sellerId") String sellerId) {
        Room room = messageService.contactSeller(buyerId, sellerId);
        if (room == null) {
            return Result.operateFailed();
        }
        return Result.success("联系成功", room);
    }







}
