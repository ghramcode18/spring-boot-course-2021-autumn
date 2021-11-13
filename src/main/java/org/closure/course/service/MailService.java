package org.closure.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service    
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public void authEmail(
      String to, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("thee.closure@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }
}
