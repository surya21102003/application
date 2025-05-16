package com.demo.projectmanagementsystem.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceimpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmialWithToken(String useremail, String link) throws Exception {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,"utf-8");
        String subjects="join project tyeam invitation";
        String text="click the link to join the project team";
        helper.setSubject(subjects);
        helper.setText(text,text);
        helper.setTo(useremail);
        try {
            javaMailSender.send(mimeMessage);
        }catch (MailException e){
            System.out.println(e);
            throw new MailSendException("faild to send mail");


        }
    }
}
