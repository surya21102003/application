package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Chat;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    Chat createchat(Chat chat);
}
