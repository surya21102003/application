package com.example.task.service.service;

import com.example.task.service.modal.Userdto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="Task-USER-SERVICE",url="http://localhost:5002")
public interface Userservice {
    @GetMapping("/api/user/profile")
    public Userdto  getuserprofile(@RequestHeader("Authorization") String jwt);

}
