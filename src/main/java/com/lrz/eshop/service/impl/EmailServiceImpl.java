package com.lrz.eshop.service.impl;

import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import com.lrz.eshop.service.EmailService;
import com.lrz.eshop.controller.dto.EmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;

/**
 * 发送电子邮件
 * @author 天天
 * @create 2023/1/21 1:17
 * @description
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailAccount mailAccount;

    @Override
    public void sendRegistryCode(EmailDto emailDto) {
        String mailContend = BuildContent(emailDto.getContent());
        // 发送邮件
        sendMail(emailDto.getTos().get(0), emailDto.getSubject(), mailContend);
    }


    /**
     *
     * @param to
     * @param subject
     * @param content
     */
    public void sendMail(String to, String subject, String content) {
        try {
            String sendStr = Mail.create(mailAccount)
                    .setTos(to)
                    .setTitle(subject)
                    .setContent(content)
                    .setHtml(true)
                    .send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String BuildContent(String code) {
        //加载邮件html模板
        // src/main/resources/templates/CaptchaMail.html
        Resource resource = new ClassPathResource("templates/CaptchaMail.html");
        InputStream inputStream = null;
        BufferedReader fileReader = null;
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            inputStream = resource.getInputStream();
            fileReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            // "发送邮件读取模板失败{}"
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //替换html模板中的参数
        return MessageFormat.format(buffer.toString(), code);
    }


}
