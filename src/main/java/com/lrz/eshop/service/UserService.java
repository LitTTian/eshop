package com.lrz.eshop.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lrz.eshop.controller.dto.UserDto;
import com.lrz.eshop.pojo.common.Star;
import com.lrz.eshop.pojo.user.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 天天
 * @create 2023/1/21 2:21
 * @description
 */
public interface UserService {

    /**
     * 根据id查询用户数据
     * @param id
     * @return
     */
    User selectUserInfoById(String id);

    /**
     * 插入信息
     * @param user
     * @return
     */
    int insert(User user);
    /**
     * 根据主键更新user表
     * @param user
     * @return
     */
    int updateById(User user);

    /**
     * 根据userUpdateWrapper更新user表
     * @param user
     * @param userUpdateWrapper
     * @return
     */
    int update(User user, UpdateWrapper<User> userUpdateWrapper);


    /**
     * 根据主键删除user表中的记录
     * @param id
     * @return
     */
    int deleteById(String id);


    /**
     * 查询条件全部记录
     * @return
     */
    List<User> selectList(Wrapper<User> queryWrapper);
    // List<User> selectAllUserAndTrades();

    /**
     * 判断是否存在
     * @param queryWrapper
     * @return
     */
    Boolean exist(Wrapper<User> queryWrapper);

    Boolean existId(String id);
    Boolean existUsername(String username);
    Boolean existEmail(String id);
    User verifyUser(UserDto user);


    User getUserInfoByToken(String token);

    int selectLocationSeqByUserId(String userId);
    Location addLocation(Location location);

    Location deleteLocation(String locationId);

    Location updateLocation(Location location);

    UserSellInfo selectSellInfoByUserId(String userId);

    UserCommunityInfo selectCommunityInfoByUserId(String userId);

    UserInfo selectUserInfo(String userId);
}
