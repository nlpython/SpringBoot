package com.example.service;

import javax.mail.MessagingException;

public interface SendMailService {

    void sendSimpleMail();

    void sendMimeMail() throws MessagingException;
}
