package com.example;

import com.example.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class JavamailApplicationTests {

    @Autowired
    private SendMailService sendMail;

    @Test
    void testSendSimpleMail() {
        sendMail.sendSimpleMail();
    }

    @Test
    void testSendMimeMail() throws MessagingException {
        sendMail.sendMimeMail();
    }

}
