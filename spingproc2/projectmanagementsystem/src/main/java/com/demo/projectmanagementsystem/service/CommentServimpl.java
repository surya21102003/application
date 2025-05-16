package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Comments;
import com.demo.projectmanagementsystem.model.Issue;
import com.demo.projectmanagementsystem.model.MyUserRepository;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.repo.CommentRepo;
import com.demo.projectmanagementsystem.repo.IssueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServimpl implements CommentService{
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private IssueRepo issueRepo;
    @Autowired
    private MyUserRepository userRepository;


    @Override
    public Comments createComment(Long issueid, Long userid, String comment) throws Exception {
        Optional<Issue> issue=issueRepo.findById(issueid);
        Optional<Myuser> user=userRepository.findById(userid);
        if (issue.isEmpty()){
            throw new Exception("issue not found");

        }
        if (user.isEmpty()){
            throw new Exception("user not foind");
        }
        Issue issue1=issue.get();
        Myuser user1=user.get();
        Comments comments=new Comments();
        comments.setIssue(issue1);
        comments.setMyuser(user1);
        comments.setCreatedtime(LocalDateTime.now());
        Comments comments1=commentRepo.save(comments);
        issue1.getComments().add(comments1);
        return comments1;
    }

    @Override
    public void deleteComment(Long commentid, Long userid) throws Exception {
        Optional<Comments> comments=commentRepo.findById(commentid);
        Optional<Myuser> user=userRepository.findById(userid);
        if (comments.isEmpty()){
            throw new Exception("not foind");
        }
        if (user.isEmpty()){
            throw new Exception("user not foind");
        }
        Comments comments1=comments.get();
        Myuser myuser=user.get();
        if (comments1.getMyuser().equals(myuser)){
            commentRepo.delete(comments1);
        }else {
            throw new Exception("user no permission to delete comments");
        }

    }

    @Override
    public List<Comments> findCommentByIssueId(Long issueid) throws Exception {

        return commentRepo.findByIssueId(issueid);
    }
}
