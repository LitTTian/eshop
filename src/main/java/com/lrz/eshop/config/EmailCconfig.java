package com.lrz.eshop.config;

import cn.hutool.extra.mail.MailAccount;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 邮箱配置
 * @author 天天
 * @create 2023/1/22 0:59
 * @description
 */
@Configuration
public class EmailCconfig {

    @Value("${mail.email}")
    private String email;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private String port;
    @Value("${mail.username}")
    private String user;
    @Value("${mail.password}")
    private String password;

    @Bean
    public MailAccount createMailAccount() {
        // 读取邮箱配置
        if (email == null || host == null || port == null || user == null || password == null) {
            throw new RuntimeException("邮箱配置异常");
        }
        MailAccount mailAccount = new MailAccount();
        mailAccount.setHost(host);
        mailAccount.setPort(Integer.parseInt(port));
        // 设置发送人邮箱
        mailAccount.setFrom(email);
        // 设置发送人名称
        // mailAccount.setUser(user.replace(" ", "") + "<" + email + ">");
        // 这个user必须是邮件的用户名("@"前面的部分)
        mailAccount.setUser(user);
        // 设置发送授权码
        mailAccount.setPass(password);
        mailAccount.setAuth(true);
        // ssl方式发送
        mailAccount.setSslEnable(true);
        // 使用安全连接
        mailAccount.setStarttlsEnable(true);
        try{
            // 跳过证书验证
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            mailAccount.setCustomProperty("mail.smtp.ssl.socketFactory", sf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mailAccount;
    }

}
