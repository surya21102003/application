package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Chat;
import com.demo.projectmanagementsystem.repo.Chatrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Chatserviceimpl implements ChatService{

    @Autowired
    private Chatrepo chatrepo;

    @Override
    public Chat createchat(Chat chat) {

        return chatrepo.save(chat);
    }
}
