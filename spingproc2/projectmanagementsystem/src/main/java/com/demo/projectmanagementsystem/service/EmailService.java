package com.demo.projectmanagementsystem.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void sendEmialWithToken(String useremail,String link)throws Exception;
}
