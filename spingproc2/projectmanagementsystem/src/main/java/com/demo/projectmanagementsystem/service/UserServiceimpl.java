package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.config.JwtService;
import com.demo.projectmanagementsystem.model.MyUserRepository;
import com.demo.projectmanagementsystem.model.Myuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private JwtService jwtService;


    @Override
    public Myuser finduserprofilebyjwt(String jwt) throws Exception {
        String email=jwtService.extractemail(jwt);
       // String user=jwtService.extractUsername(jwt);
      //   return user;
        return finduserbyemail(email);
    }

    @Override
    public Myuser finduserbyemail(String email) throws Exception {
        Myuser user=myUserRepository.findByEmail(email);
        if (user==null){
            throw new Exception("not found");
        }
        return user;
    }

    @Override
    public Myuser finduserbyid(Long userid) throws Exception {
        Optional<Myuser> user=myUserRepository.findById(userid);
        if (user.isEmpty()){
            throw new Exception("not fouind by id");
        }
        return user.get();
    }

    @Override
    public Myuser updateuserprojectsize(Myuser myuser, int number) {
        myuser.setProjectsize(myuser.getProjectsize()+number);

        return myUserRepository.save(myuser);
    }
}
