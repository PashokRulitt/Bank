//package com.example.demo.Config;
//
//import jdk.nashorn.internal.objects.annotations.Property;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import sun.security.pkcs11.P11Util;
//
//import java.util.Properties;
//
//@Configuration
//public class EmailConfig {
//    @Value("smtp.gmail.com")
//    private String host;
//
//    @Value("465")
//    private int  port;
//
//
//    @Value("smtp")
//    private String protocol;
//
//    @Value("${username}")
//    private String username;
//
//    @Value("")
//    private String password;
//
//
//    @Bean
//    public JavaMailSender javaMailSender(){
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost(host);
//        mailSender.setPort(port);
//        mailSender.setUsername(username);
//        mailSender.setPassword(password);
//        Properties properties = mailSender.getJavaMailProperties();
//        properties.setProperty("protocol",protocol);
//        return mailSender;
//    }
//}
