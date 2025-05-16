package com.example.task.controller;


import com.example.task.config.Jwtprovider;
import com.example.task.model.User;
import com.example.task.repositories.UserRepo;
import com.example.task.request.loginRequest;
import com.example.task.response.AuthResponse;
import com.example.task.service.CustomUserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserService customUserService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUser(@RequestBody User user) throws Exception {
        String email= user.getEmail();
        String password= user.getPassword();
        String fullname= user.getFullname();
        String role= user.getRole();
        User iseemailExist=userRepo.findByEmail(email);
        if (iseemailExist!=null){
            throw new Exception("email already presebt");
        }
        User createUser=new User();
        createUser.setEmail(email);
        createUser.setFullname(fullname);
        createUser.setRole(role);
        createUser.setPassword(passwordEncoder.encode(password));
        User savedUser=userRepo.save(createUser);

        Authentication authentication=new UsernamePasswordAuthenticationToken(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= Jwtprovider.generateToken(authentication);

         AuthResponse authResponse=new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("register success");

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody loginRequest loginrequest){
String username= loginrequest.getEmail();
String password=loginrequest.getPassword();
System.out.println(username+"--"+password);

        Authentication authentication=authenticate(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token= Jwtprovider.generateToken(authentication);

        AuthResponse authResponse=new AuthResponse();
        authResponse.setJwt(token);
        authResponse.setMessage("login success");
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    public Authentication authenticate(String username,String password){
        UserDetails userDetails=customUserService.loadUserByUsername(username);
        System.out.println("sign in userdetaild"+userDetails);
        if (userDetails==null){
            throw new BadCredentialsException("invalid user or passsword");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("invalid user orpassword");
        }
        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

    }
}
