package com.koleychik.test_spring_mail;

import lombok.Data;

@Data
public class EmailModel {

    private String from = "betommyclay@gmail.com";

    private String to, subject, text;

    public EmailModel(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
}
