package com.example.service.impl;

import com.example.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * SendMailServiceImpl
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    // 发送人
    private String from = "2994056734@qq.com";
    // 接受人
//    private String to = "202031119020167@stu.hubu.edu.cn";
    private String to = "1105579600@qq.com";
    // 标题
    private String subject = "测试邮件";
    // 正文
    private String context = "测试邮件正文";
    private String text = "<a href='https://www.baidu.com'>点我</a>";


    @Override
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from + "(yruns)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }

    @Override
    public void sendMimeMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from + "(yruns)");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);

        // 发送附件
        File pict = new File("C:\\Users\\86185\\Pictures\\pict.jpg");
        helper.addAttachment("头像.png", pict);

        javaMailSender.send(mimeMessage);
    }


}
