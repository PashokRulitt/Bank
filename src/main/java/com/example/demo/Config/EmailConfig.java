package com.example.demo.Config;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import sun.security.pkcs11.P11Util;

import java.util.Properties;


public class EmailConfig {
    @Value("$(host)")
    private String host;

    @Value("${port}")
    private int  port;


    @Value("${protocol}")
    private String protocol;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${debug}")
    private String debug;

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        Properties properties =mailSender.getJavaMailProperties();
        properties.setProperty("mail.debug",debug);
        properties.setProperty("mail.transport.protocol",protocol);
        return mailSender;
    }
}
