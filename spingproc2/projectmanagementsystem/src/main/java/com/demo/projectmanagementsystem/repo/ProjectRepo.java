package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Projects,Long> {
//List<Projects> findByOwner(Myuser myuser);

List<Projects> findByNameContainingAndTeamContaining(String partialnumber,Myuser myuser);

//@Query("SELECT p from Projects p join p.team t where t=:user")
//List<Projects> findprojectByTeam(@Param("user") Myuser myuser);

List<Projects> findByTeamContainingOrOwner(Myuser myuser,Myuser owner);
}
