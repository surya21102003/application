package com.example.task.service;

import com.example.task.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getuserprofile(String jwt);
    List<User> getallusers();
}
