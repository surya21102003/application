package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Issue;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Projects;
import com.demo.projectmanagementsystem.repo.IssueRepo;
import com.demo.projectmanagementsystem.request.IssueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueServiceimpl implements IssueService{

    @Autowired
    private IssueRepo issueRepo;

    @Autowired
    private Projectservice projectservice;

    @Autowired
    private UserService userService;
    @Override
    public Issue getIssueById(Long issueId) throws Exception {
        Optional<Issue> issue=issueRepo.findById(issueId);
        if (issue.isPresent()){
            return issue.get();
        }
        throw new Exception("no issue found with isssueid"+issueId);
    }

    @Override
    public List<Issue> getIssueByProjectId(Long projectId) throws Exception {

        return issueRepo.findByProjectid(projectId);
    }

    @Override
    public Issue createIssue(IssueRequest req, Myuser myuser) throws Exception {
        Projects projects=projectservice.getprojectsbyid(req.getProejctid());
        Issue issue=new Issue();
        issue.setTitle(req.getTitle());
        issue.setDecription(req.getDecription());
        issue.setStatus(req.getStatus());
        issue.setProejctid(req.getProejctid());
        issue.setPriority(req.getPriority());
        issue.setDuedate(req.getDuedate());
        issue.setProjects(projects);

        return issueRepo.save(issue);
    }

    @Override
    public void deleteIssue(Long issueid, Long userid) throws Exception {
        getIssueById(issueid);
        issueRepo.deleteById(issueid);
    }

    @Override
    public Issue addUserToIssue(Long issueId, Long userId) throws Exception {
        Myuser user=userService.finduserbyid(userId);
       Issue issue=getIssueById(issueId);
       issue.setAssignee(user);

        return issueRepo.save(issue);
    }

    @Override
    public Issue updateStatus(Long issueId, String status) throws Exception {
        Issue issue=getIssueById(issueId);
        issue.setStatus(status);

        return issueRepo.save(issue);
    }
}
