package com.kcj.project.board.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private JavaMailSender mailSender;

    public void sendTestSimpleMessage(){
        SimpleMailMessage message = new SimpleMailMessage();
    }
}
