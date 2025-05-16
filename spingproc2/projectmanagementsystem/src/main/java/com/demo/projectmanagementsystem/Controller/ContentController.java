package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.config.JwtService;
import com.demo.projectmanagementsystem.model.LoginForm;
import com.demo.projectmanagementsystem.model.MyUserDetailService;
import com.demo.projectmanagementsystem.model.MyUserRepository;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ContentController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private MyUserRepository userRepository;

    @PostMapping("/signin")
    public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginForm.email(), loginForm.password()
        ));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(myUserDetailService.loadUserByUsername(loginForm.email()));
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }



    @PostMapping("/signup")
    public Myuser createUser(@RequestBody Myuser user) {

        //     user.setPassword(passwordEncoder.encode(user.getPassword()));
        Myuser user1=new Myuser();
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setRole(user.getRole());

        Myuser save=userRepository.save(user1);

        subscriptionService.createSubscription(save);
        return save;
    }
}
