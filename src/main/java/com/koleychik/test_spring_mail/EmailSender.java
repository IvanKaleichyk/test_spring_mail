package com.koleychik.test_spring_mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    private final JavaMailSender javaMailSender;
    private final EmailConfig config;

    @Autowired
    public EmailSender(EmailConfig config) {
        this.config = config;
//        this.javaMailSender = javaMailSender;
        this.javaMailSender = config.getJavaMailSender();
    }

    public void send(EmailModel model){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(model.getFrom());
        mailMessage.setTo(model.getTo());
        mailMessage.setSubject(model.getSubject());
        mailMessage.setText(model.getText());

        javaMailSender.send(mailMessage);

    }

}
