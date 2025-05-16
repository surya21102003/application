package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Plantype;
import com.demo.projectmanagementsystem.model.Subscription;
import com.demo.projectmanagementsystem.service.SubscriptionService;
import com.demo.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubsCriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public ResponseEntity<Subscription> getusersubscription(
            @RequestParam("Authorization")String jwt
    ) throws Exception {
        Myuser myuser=userService.finduserprofilebyjwt(jwt);
        Subscription subscription=subscriptionService.getuserssubscription(myuser.getId());
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }


    @PatchMapping("/upgrade")
    public ResponseEntity<Subscription> upgradesubscription(
            @RequestParam Plantype plantype,
            @RequestParam("Authorization")String jwt
    ) throws Exception {
        Myuser myuser=userService.finduserprofilebyjwt(jwt);
        Subscription subscription=subscriptionService.upgradrsubscription(myuser.getId(),plantype);
        return new ResponseEntity<>(subscription, HttpStatus.OK);
    }


}
