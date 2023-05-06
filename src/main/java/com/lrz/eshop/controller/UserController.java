package com.lrz.eshop.controller;

import com.lrz.eshop.common.webapi.Result;
import com.lrz.eshop.common.webapi.ResultCode;
import com.lrz.eshop.pojo.user.Location;
import com.lrz.eshop.pojo.user.User;
import com.lrz.eshop.controller.dto.UserDto;
import com.lrz.eshop.service.TradeService;
import com.lrz.eshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户信息控制类
 * @author 天天
 * @create 2023/1/19 2:51
 * @description
 */
@Api(tags = "user-controller")
@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TradeService tradeService;

/*     @ApiOperation("根据id查询用户的商城信息")
    @GetMapping("/getSellInfoByUserId")
    public Result<?> selectSellInfoByUserId(@RequestParam String userId) {
        return Result.success(userService.selectSellInfoByUserId(userId));
    }
    @ApiOperation("根据id查询用户的社区信息")
    @GetMapping("/getCommunityInfoByUserId")
    public Result<?> selectCommunityInfoByUserId(@RequestParam String userId) {
        return Result.success(userService.selectCommunityInfoByUserId(userId));
    } */

    @ApiOperation("根据id查询用户个人中心信息")
    @GetMapping("/getUserInfo/{userId}")
    public Result<?> selectUserInfo(@PathVariable(value = "userId") String userId) {
        return Result.success(userService.selectUserInfo(userId));
    }



    /**
     * 注册时确认用户名密码，并存入session
     * @param user 用户名
     * @return 用户对象
     */
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        // System.out.println(user);
        // 判断是否已存在用户
        if(userService.existEmail(user.getEmail())) {
            System.out.println("邮箱已存在");
            return Result.failed(ResultCode.EmailAlreadyExist);
        }

        if (userService.existUsername(user.getUsername())) {
            System.out.println("用户名已存在");
            return Result.failed(ResultCode.UsernameAlreadyExist);
        }
        // 使用sha1加密
        // user.setPassword(EncryptUtils.encodeWithSha1(user.setPassword()));
        userService.insert(user);
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        User userDB = userService.verifyUser(userDto);
        // id 在 session中保存为String，为的是防止Long在存储雪花算法得到的id时丢失精度
        // session.setAttribute("id", String.valueOf(userDB.getId()));
        return Result.success("注册成功", userDB);
    }


    /**
     * 查询用户名是否已经存在
     * @param username 用户名
     * @return {"message": "message", result: true/false}
     * true代表存在
     */
    @PostMapping("/existUsername")
    public Result<?> existUsername(@RequestParam String username) {
        return userService.existUsername(username)?
                Result.failed(ResultCode.UsernameAlreadyExist, true):
                Result.success("用户名可用", false);
    }

    /**
     * 查询邮箱是否已经存在
     * @param email 邮箱
     * @return {"message": "message", result: true/false}
     */
    @PostMapping("/existEmail")
    public Result<?> existEmail(@RequestParam String email) {
        return userService.existEmail(email)?
                Result.failed(ResultCode.EmailAlreadyExist, true):
                Result.success("邮箱可用", false);
    }



    @ApiOperation("新增地址")
    @PostMapping("/addLocation")
    public Result< ? > addLocation(@RequestBody Location location) {
        if(location.getUserId() == null) {
            return Result.operateFailed();
        }
        Location LocationDB = userService.addLocation(location);
        if(LocationDB == null) {
            return Result.operateFailed();
        }
        return Result.success("添加地址成功", LocationDB);
    }

    @ApiOperation("移除地址，并不是真正删除地址记录，而是设置state为0")
    @PostMapping("/deleteLocation")
    public Result< ? > deleteLocation(@RequestParam("locationId") String locationId) {
        // 因为地址信息对订单信息有用，所以并不是真正删除地址记录，而是设置标志位
        Location location = userService.deleteLocation(locationId);
        if(location == null) {
            return Result.operateFailed();
        }
        return Result.success("移除成功！", location);
    }

    @ApiOperation("修改地址")
    @PostMapping("/updateLocation")
    public Result< ? > updateLocation(@RequestBody Location location) {
        Location locationDB = userService.updateLocation(location);
        if(locationDB == null) {
            return Result.operateFailed();
        }
        return Result.success("修改地址成功", locationDB);
    }


}
