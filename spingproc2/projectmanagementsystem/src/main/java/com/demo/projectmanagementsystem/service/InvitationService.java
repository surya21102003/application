package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Invitation;
import org.springframework.stereotype.Service;

@Service
public interface InvitationService {
    public Invitation sendinvitation(String email, Long projectId) throws Exception;
    public Invitation acceptInvitation(String token,long userid) throws Exception;
    public String gettokenByUserMail(String useremail);
    void deleteToken(String token);

}
