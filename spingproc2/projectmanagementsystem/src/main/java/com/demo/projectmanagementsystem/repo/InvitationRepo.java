package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepo extends JpaRepository<Invitation,Long> {

    Invitation findByToken(String token);
    Invitation findByEmail(String userEmail);

}
