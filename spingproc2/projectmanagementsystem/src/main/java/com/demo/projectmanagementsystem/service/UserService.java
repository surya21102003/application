package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Myuser;

public interface UserService {
    Myuser finduserprofilebyjwt(String jwt)throws Exception;
    Myuser finduserbyemail(String email)throws Exception;
    Myuser finduserbyid(Long userid)throws Exception;
    Myuser updateuserprojectsize(Myuser myuser,int number);

}
