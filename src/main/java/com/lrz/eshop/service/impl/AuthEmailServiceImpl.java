package com.lrz.eshop.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateConfig;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.TemplateUtil;
import com.lrz.eshop.pojo.User;
import com.lrz.eshop.service.AuthEmailService;
import com.lrz.eshop.service.EmailService;
import com.lrz.eshop.service.UserService;
import com.lrz.eshop.service.dto.AuthUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * 验证邮箱服务
 * @author 天天
 * @create 2023/1/21 2:08
 * @description
 */

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AuthEmailServiceImpl implements AuthEmailService {

    // 验证码有效期：expiration秒
    @Value("${mail.code.expiration}")
    private Long expiration;

    @Autowired
    private final EmailService emailService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String register(AuthUserDto authUserDto) {
        // ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        // 通过email获取redis中的code
        /*Object value = valueOperations.get(authUserDto.getEmail());
        if (value == null || !value.toString().equals(authUserDto.getCode())) {
            return ("无效验证码！");
        }*/

        // 如果前端没有传入用户名，则以邮箱号作为用户名进行注册
        String userName = StringUtils.isEmpty(authUserDto.getUsername()) ? authUserDto.getEmail() : authUserDto.getUsername();

        if (userService.existUsername(userName)) {
            return ("用户名已存在！");
        }

        // 创建用户
        User user = new User();
        user.setUsername(userName);
        try {
            user.setPwd(authUserDto.getPassword());
        } catch (Exception e) {
            return ("注册密码异常！");
        }
        user.setEmail(authUserDto.getEmail());
        if(userService.insert(user) == 0){
            return ("用户注册失败！");
        };
        // redisTemplate.delete(authUserDto.getEmail());
        return ("用户注册成功！");
    }

    @Override
    public String sendMailCode(String email) {
        // ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

        // 查看注册邮箱是否存在
        if (userService.existEmail(email)) {
            return ("邮箱已被注册！");
        }

        // 获取发送邮箱验证码的HTML模板
        TemplateEngine engine = TemplateUtil.createEngine(new TemplateConfig("templates", TemplateConfig.ResourceMode.CLASSPATH));
        Template template = engine.getTemplate("email-code.ftl");

        // 从redis缓存中尝试获取验证码
        Object code = null;
        // Object code = valueOperations.get(email);
        if (code == null) {
            // 如果在缓存中未获取到验证码，则产生6位随机数，放入缓存中
            code = RandomUtil.randomNumbers(6);
            try {
                // valueOperations.set(email, code, expiration, TimeUnit.SECONDS);
            } catch (Exception e) {
                // return RespBean.error("后台缓存服务异常");
            }
        }
        // 发送验证码
        // emailService.sendRegistryCode();
        return ("验证码发送成功");

    }
}
