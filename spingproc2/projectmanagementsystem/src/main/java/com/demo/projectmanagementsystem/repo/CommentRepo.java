package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comments,Long> {

    List<Comments> findByIssueId(Long Issueid);
}
