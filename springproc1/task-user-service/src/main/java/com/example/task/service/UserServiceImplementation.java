package com.example.task.service;

import com.example.task.config.Jwtprovider;
import com.example.task.model.User;
import com.example.task.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getuserprofile(String jwt) {
        String email=Jwtprovider.getemailfromjwttoken(jwt);
       return userRepo.findByEmail(email);


    }

    @Override
    public List<User> getallusers() {

        return userRepo.findAll();
    }
}
