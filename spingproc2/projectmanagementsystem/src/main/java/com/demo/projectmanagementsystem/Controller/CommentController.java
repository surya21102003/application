package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.model.Comments;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.request.CreateCommentRequest;
import com.demo.projectmanagementsystem.service.CommentService;
import com.demo.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Comments> createComment(
            @RequestBody CreateCommentRequest req,
            @RequestParam("Authorization")String jwt
    )throws Exception{
        Myuser user=userService.finduserprofilebyjwt(jwt);
        Comments comments=commentService.createComment(req.getIssueid(), user.getId(), req.getContent());
    return new ResponseEntity<>(comments, HttpStatus.CREATED);
    }

    @DeleteMapping("/{commentid}")
    public ResponseEntity<String> deleteComment(
            @PathVariable Long connectid,
            @RequestParam("Authorization")String jwt
    )throws Exception{
        Myuser user=userService.finduserprofilebyjwt(jwt);
        commentService.deleteComment(connectid, user.getId());
        return new ResponseEntity<>("comment deleted", HttpStatus.CREATED);
    }
    @GetMapping("/{issueid}")
    public ResponseEntity<List<Comments>> getCommentByissue(@PathVariable Long issueid) throws Exception {
        List<Comments> comments=commentService.findCommentByIssueId(issueid);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }
}
