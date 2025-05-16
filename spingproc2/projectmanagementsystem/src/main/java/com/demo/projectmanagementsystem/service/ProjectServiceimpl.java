package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Chat;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Projects;
import com.demo.projectmanagementsystem.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectServiceimpl implements Projectservice{

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;

    @Override
    public Projects createproject(Projects projects, Myuser myuser) throws Exception {
        Projects createdproect=new Projects();
        createdproect.setOwner(myuser);
        createdproect.setTags(projects.getTags());
        createdproect.setName(projects.getName());
        createdproect.setCategory(projects.getCategory());
        createdproect.setDescription(projects.getDescription());
        createdproect.getTeam().add(myuser);
        Projects save=projectRepo.save(createdproect);

        Chat chat=new Chat();
        chat.setProject(save);

        Chat projectchat=chatService.createchat(chat);
        save.setChat(projectchat);

        return save;
    }

    @Override
    public List<Projects> getprojectteam(Myuser myuser, String category, String tag) throws Exception {
      List<Projects> project=projectRepo.findByTeamContainingOrOwner(myuser,myuser);
      if (category!=null){
          project=project.stream().filter(projects->projects.getCategory().equals(category))
                  .collect(Collectors.toUnmodifiableList());
      }
        if (tag!=null){
            project=project.stream().filter(projects->projects.getTags().contains(tag))
                    .collect(Collectors.toUnmodifiableList());
        }

        return project;
    }

    @Override
    public Projects getprojectsbyid(Long projectid) throws Exception {
        Optional<Projects> projects=projectRepo.findById(projectid);
        if (projects.isEmpty()){
            throw new Exception("not found");
        }
        return projects.get();
    }

    @Override
    public void deleteproject(Long projectid, Long userid) throws Exception {
        getprojectsbyid(projectid);
      //  userService.finduserbyid(userid);
        projectRepo.deleteById(projectid);
    }

    @Override
    public Projects updateprojects(Projects updatedproject, Long id) throws Exception {
        Projects projects=getprojectsbyid(id);
        projects.setName(updatedproject.getName());
        projects.setDescription(updatedproject.getDescription());
        projects.setTags(updatedproject.getTags());
        return projectRepo.save(projects);
    }

    @Override
    public void addusertoproject(Long Projectid, Long userid) throws Exception {
Projects projects=getprojectsbyid(Projectid);
Myuser myuser=userService.finduserbyid(userid);
if (!projects.getTeam().contains(myuser)){
    projects.getChat().getUsername().add(myuser);
    projects.getTeam().add(myuser);
}
projectRepo.save(projects);
    }

    @Override
    public void remoceuserfromproject(Long Projectid, Long userid) throws Exception {
        Projects projects=getprojectsbyid(Projectid);
        Myuser myuser=userService.finduserbyid(userid);
        if (projects.getTeam().contains(myuser)){
            projects.getChat().getUsername().remove(myuser);
            projects.getTeam().remove(myuser);
        }
        projectRepo.save(projects);
    }

    @Override
    public Chat getchatbyprojectid(Long projectid) throws Exception {
        Projects projects=getprojectsbyid(projectid);
        return projects.getChat();

    }

    @Override
    public List<Projects> searchprojects(String keyword, Myuser user) throws Exception {


        return projectRepo.findByNameContainingAndTeamContaining(keyword, user);
    }
}
