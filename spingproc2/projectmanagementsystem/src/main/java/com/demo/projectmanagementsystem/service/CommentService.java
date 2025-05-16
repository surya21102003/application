package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comments createComment(Long issueid,Long userid,String comment)throws Exception;
    void deleteComment(Long commentid,Long userid)throws Exception;
    List<Comments> findCommentByIssueId(Long issueid)throws Exception;
}
