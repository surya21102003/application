package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.Dto.IssueDto;
import com.demo.projectmanagementsystem.model.Issue;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.request.IssueRequest;
import com.demo.projectmanagementsystem.service.IssueService;
import com.demo.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {
    @Autowired
    private IssueService issueService;
    @Autowired
    private UserService userService;

    @GetMapping("/{issueId}")
    public ResponseEntity<Issue> getIssueById(@PathVariable Long issueId)throws Exception{
        return ResponseEntity.ok(issueService.getIssueById(issueId));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Issue>> getIssueByProjectId(@PathVariable Long issueid)throws Exception{
        return ResponseEntity.ok(issueService.getIssueByProjectId(issueid));
    }

    @PostMapping
    public ResponseEntity<IssueDto> createissue(
            @RequestBody IssueRequest issue,
            @RequestParam("Authorization")String jwt)throws Exception{
        Myuser tokenuser=userService.finduserprofilebyjwt(jwt);
        Myuser user=userService.finduserbyid(tokenuser.getId());
        Issue ci=issueService.createIssue(issue,tokenuser);
        IssueDto issueDto=new IssueDto();
        issueDto.setDecription(ci.getDecription());
        issueDto.setDuedate(ci.getDuedate());
        issueDto.setId(ci.getId());
        issueDto.setPriority(ci.getPriority());
        issueDto.setProjects(ci.getProjects());
        issueDto.setProejctid(ci.getProejctid());
        issueDto.setStatus(ci.getStatus());
        issueDto.setTitle(ci.getTitle());
        issueDto.setTags(ci.getTags());
        issueDto.setAssignee(ci.getAssignee());

        return ResponseEntity.ok(issueDto);

    }

    @DeleteMapping("/{issueid}")
    public ResponseEntity<String>  deleteissue(@PathVariable Long  id,
                                               @RequestParam("Authorization")String jwt )throws Exception{

        Myuser user=userService.finduserprofilebyjwt(jwt);
        issueService.deleteIssue(id, user.getId());
        return ResponseEntity.ok("issue delete");
    }

    @PutMapping("/{issueId}/assignee/{userId}")
    public ResponseEntity<Issue> addusertoissue(
            @PathVariable Long  issueid,
            @PathVariable Long  userid
    )throws Exception{
        Issue issue=issueService.addUserToIssue(issueid, userid);
        return ResponseEntity.ok(issue);
    }

    @PutMapping("/{issueId}/status/{status}")
    public ResponseEntity<Issue> updateissuestatus(
            @PathVariable String status,
            @PathVariable Long  issueid
    )throws Exception{
        Issue issue=issueService.updateStatus(issueid,status);
        return ResponseEntity.ok(issue);
    }


}
