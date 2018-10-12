package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender javaMailSender;


    private String username= "pashaload@gmail.com";

    public void send(String emailTo,String subject,String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(username);
        simpleMailMessage.setFrom(emailTo);
        simpleMailMessage.setFrom(subject);
        simpleMailMessage.setFrom(message);
        javaMailSender.send(simpleMailMessage);
    }
}
