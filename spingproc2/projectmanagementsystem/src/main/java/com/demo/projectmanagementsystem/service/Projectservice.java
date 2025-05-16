package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Chat;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Projects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Projectservice {

Projects createproject(Projects projects,Myuser myuser)throws Exception;
List<Projects> getprojectteam(Myuser myuser,String category,String tag)throws Exception;
Projects getprojectsbyid(Long projectid)throws Exception;
void deleteproject(Long projectid,Long userid)throws Exception;
Projects updateprojects(Projects updatedproject,Long id)throws Exception;
void addusertoproject(Long Projectid,Long userid)throws Exception;
void remoceuserfromproject(Long Projectid,Long userid)throws Exception;
Chat getchatbyprojectid(Long projectid)throws Exception;

List<Projects> searchprojects(String keyword,Myuser user)throws Exception;
}
