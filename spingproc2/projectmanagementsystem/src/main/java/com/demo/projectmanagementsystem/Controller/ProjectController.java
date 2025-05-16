package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.model.Chat;
import com.demo.projectmanagementsystem.model.Invitation;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Projects;
import com.demo.projectmanagementsystem.request.InvitationRequest;
import com.demo.projectmanagementsystem.service.InvitationService;
import com.demo.projectmanagementsystem.service.Projectservice;
import com.demo.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private Projectservice projectservice;

    @Autowired
    private UserService userService;


    @Autowired
    private InvitationService invitationService;
    @GetMapping()
    public ResponseEntity<List<Projects>> getprojects(
            @RequestParam(required = false)String category,
            @RequestParam(required = false)String tag,
            @RequestParam("Authorization")String jwt
            ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
        List<Projects> projects=projectservice.getprojectteam(user,category,tag);

        return new ResponseEntity<>(projects, HttpStatus.OK);

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Projects> getprojectsById(
            @PathVariable Long projectid,
            @RequestParam("Authorization")String jwt
    ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
        Projects projects=projectservice.getprojectsbyid(projectid);

        return new ResponseEntity<>(projects, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Projects> createprojects(
            @RequestBody Projects project,
            @RequestParam("Authorization")String jwt
    ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
        Projects createprojects=projectservice.createproject(project,user);

        return new ResponseEntity<>(createprojects, HttpStatus.OK);

    }
    @PatchMapping("/{projectId}")
    public ResponseEntity<Projects> updateprojects(
            @PathVariable Long projectid,
            @RequestParam("Authorization")String jwt,
            @RequestBody Projects project

            ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
        Projects createprojects=projectservice.updateprojects(project,projectid);

        return new ResponseEntity<>(createprojects, HttpStatus.OK);

    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<Projects> deleteprojects(
            @PathVariable Long projectid,
            @RequestParam("Authorization")String jwt

    ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
        projectservice.deleteproject(projectid, user.getId());
        System.out.println("project delete successfully");
        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @GetMapping("/{projectid}/chat")
    public ResponseEntity<Chat> getchatbyprojectid(
@RequestBody Long projectid,
@RequestParam("Authorization")String jwt
    ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
        Chat projects=projectservice.getchatbyprojectid(projectid);

        return new ResponseEntity<>(projects, HttpStatus.OK);

    }

    @PostMapping("/invite")
    public ResponseEntity<String> inviteprojects(
            @RequestBody InvitationRequest req,
            @RequestBody Projects project,
            @RequestParam("Authorization")String jwt
    ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
invitationService.sendinvitation(req.getEmail(), req.getProjectId());
        return new ResponseEntity<>("user invitation sent", HttpStatus.OK);

    }

    @GetMapping("/acceptinvite")
    public ResponseEntity<Invitation> acceptinviteprojects(
@RequestParam String token,
            @RequestBody Projects project,
            @RequestParam("Authorization")String jwt
    ) throws Exception {

        Myuser user=userService.finduserprofilebyjwt(jwt);
       Invitation invitation= invitationService.sendinvitation(token, user.getId());
        projectservice.addusertoproject(invitation.getProjectid(), user.getId());
        return new ResponseEntity<>(invitation, HttpStatus.ACCEPTED);

    }

}
