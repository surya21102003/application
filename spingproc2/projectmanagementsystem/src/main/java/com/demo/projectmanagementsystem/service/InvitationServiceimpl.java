package com.demo.projectmanagementsystem.service;


import com.demo.projectmanagementsystem.model.Invitation;
import com.demo.projectmanagementsystem.repo.InvitationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvitationServiceimpl implements InvitationService{

    @Autowired
    private InvitationRepo invitationRepo;

    @Autowired
    private EmailService emailService;

    @Override
    public Invitation sendinvitation(String email, Long projectId) throws Exception {
        String invitationtoken= UUID.randomUUID().toString();
        Invitation invitation=new Invitation();
        invitation.setEmail(email);
        invitation.setProjectid(projectId);
        invitation.setToken(invitationtoken);
        invitationRepo.save(invitation);
        String invitationLink="http://localhost:5173/accept_invitation?token="+invitationtoken;
        emailService.sendEmialWithToken(email,invitationLink);

        return invitation;
    }

    @Override
    public Invitation acceptInvitation(String token, long userid) throws Exception {
        Invitation invitation=invitationRepo.findByToken(token);
        if (invitation==null){
            throw new Exception("invitation not found");

        }
        return invitation;
    }

    @Override
    public String gettokenByUserMail(String useremail) {
        Invitation invitation=invitationRepo.findByEmail(useremail);

        return invitation.getToken();
    }

    @Override
    public void deleteToken(String token) {
        Invitation invitation=invitationRepo.findByToken(token);
invitationRepo.delete(invitation);
    }
}
