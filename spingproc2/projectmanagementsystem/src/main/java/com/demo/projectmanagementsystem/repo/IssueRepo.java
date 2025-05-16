package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepo extends JpaRepository<Issue,Long> {
    public List<Issue> findByProjectid(Long id);
}
