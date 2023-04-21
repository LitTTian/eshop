package com.lrz.eshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lrz.eshop.mapper.LocationMapper;
import com.lrz.eshop.mapper.StarMapper;
import com.lrz.eshop.mapper.UserInfoMapper;
import com.lrz.eshop.mapper.UserMapper;
import com.lrz.eshop.pojo.user.*;
import com.lrz.eshop.service.OssService;
import com.lrz.eshop.service.UserService;
import com.lrz.eshop.util.ImageNameUtil;
import com.lrz.eshop.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 调用UserMapper操作数据库
 * @author 天天
 * @create 2023/1/21 2:39
 * @description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    OssService ossService;

    @Autowired
    UserInfoMapper userInfoMapper;

    // @Autowired
    // RedisUtils redisUtils;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private StarMapper starMapper;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    ImageNameUtil imageNameUtil;


    @Override
    public User selectUserInfoById(String id) {
        return userMapper.selectUserInfoById(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user, UpdateWrapper<User> userUpdateWrapper) {
        return userMapper.update(user, userUpdateWrapper);
    }



    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int deleteById(String id) {
        return userMapper.deleteById(id);
    }


    @Override
    public List<User> selectList(Wrapper<User> queryWrapper) {
        return userMapper.selectList(queryWrapper);
    }

    // @Override
    // public List<User> selectAllUserAndTrades() {
    //     return userMapper.selectAllUserAndTrades();
    // }

    @Override
    public Boolean exist(Wrapper<User> queryWrapper) {
        return userMapper.exists(queryWrapper);
    }

    @Override
    public Boolean existUsername(String username) {
        return exist(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public Boolean existEmail(String email) {
        return exist(new QueryWrapper<User>().eq("email", email));
    }

    @Override
    public Boolean existId(String id) {
        return exist(new QueryWrapper<User>().eq("id", id));
    }

    @Override
    public User verifyUser(User user, HttpSession session) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        queryWrapper.eq("password", user.getPassword());
        List<User> users = selectList(queryWrapper);
        if(users.size() == 0) {
            return null;
        }else { // 登录成功
            User userDB = users.get(0);
            userDB.setPassword(null);
            // String token = UUID.randomUUID().toString();
            if(userDB.getToken() != null && !userDB.getToken().equals("")) {
                String id = TokenUtil.getIdByToken(userDB.getToken());
                if(Long.valueOf(id).equals(user.getId())) {
                    return userDB;
                }
            }
            String token = TokenUtil.sign(userDB);
            userDB.setToken(token);
            session.setAttribute("id", String.valueOf(userDB.getId()));
            System.out.println("session id: " + session.getAttribute("id"));
            // redisUtils.set(token, sUser.getId(), 60 * 60 * 24 * 7,  TimeUnit.SECONDS);
            return userDB;
        }
    }

    @Override
    public String uploadUserAvatar(MultipartFile file, User user) {
        String originPath = user.getAvatarUrl();
        if(originPath != null && !originPath.equals("")) {
            if(!ossService.deleteFile(originPath)) {
                return null;
            }
        }
        // users/123456/avatar/2021/01/19/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        String path = "users/" + user.getId() + "/avatar/" + imageNameUtil.getImgName(file.getOriginalFilename());
        // 成功返回：https://oss-cn-hangzhou.aliyuncs.com/images/users/123456/avatar/db39a8379db54ae0a92e82f498751589.jpg
        // 否则返回：null
        return ossService.uploadFile(file, path);
    }

    @Override
    public User getUserInfoByToken(String token, HttpSession session) {
        if(!TokenUtil.verify(token)) {
            return null;
        }
        String userId = TokenUtil.getIdByToken(token);
        User user = selectUserInfoById(userId);
        // String newToken = TokenUtil.sign(user);
        user.setToken(token);
        session.setAttribute("id", String.valueOf(user.getId()));
        System.out.println("session id: " + session.getAttribute("id"));
        user.setPassword(null);
        return user;
    }


    public int selectLocationSeqByUserId(String userId) {
        Integer seq = locationMapper.selectMaxSeqByUserId(userId);
        return seq == null ? 0 : seq + 1;
    }
    @Override
    public Location addLocation(Location location) {
        int seq = selectLocationSeqByUserId(String.valueOf(location.getUserId()));
        location.setSeq(seq);
        location.setState((short)1); // 1表示可用
        locationMapper.insert(location);
        if(location.getId() == null) {
            return null;
        }
        return location;
    }

    @Override
    public Location deleteLocation(String locationId) {
        Location location = locationMapper.selectById(locationId);
        if(location == null) {
            return null;
        }
        location.setState((short)0);
        locationMapper.updateById(location);
        return location;
    }

    @Override
    public Location updateLocation(Location location) {
        Location locationDB = locationMapper.selectById(location.getId());
        if(locationDB == null || locationDB.getState() == 0) {
            return null;
        }
        locationDB.setName(location.getName());
        locationDB.setPhone(location.getPhone());
        locationDB.setProvince(location.getProvince());
        locationDB.setCity(location.getCity());
        locationDB.setDistrict(location.getDistrict());
        locationDB.setStreet(location.getStreet());
        locationDB.setDetail(location.getDetail());
        locationDB.setLabel(location.getLabel());
        locationMapper.updateById(locationDB);
        return locationDB;
    }

    @Override
    public UserSellInfo selectSellInfoByUserId(String userId) {
        // UserSellInfo userSellInfo = userInfoMapper.getUserSellInfo(userId);
        // System.out.println(userSellInfo);
        // return userSellInfo;
        return userInfoMapper.getUserSellInfo(userId);
    }

    @Override
    public UserCommunityInfo selectCommunityInfoByUserId(String userId) {
        return userInfoMapper.getUserCommunityInfo(userId);
    }

    @Override
    public UserInfo selectUserInfo(String userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Long.valueOf(userId));
        userInfo.setUserSocialInfo(userInfoMapper.getUserSocialInfo(userId));
        userInfo.setUserSellInfo(userInfoMapper.getUserSellInfo(userId));
        userInfo.setUserCommunityInfo(userInfoMapper.getUserCommunityInfo(userId));
        return userInfo;
    }


}
