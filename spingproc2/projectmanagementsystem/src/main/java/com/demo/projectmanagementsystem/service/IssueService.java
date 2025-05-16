package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Issue;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.request.IssueRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IssueService {
    Issue getIssueById(Long issueId)throws Exception;
    List<Issue> getIssueByProjectId(Long projectId)throws Exception;
    Issue createIssue(IssueRequest issue, Myuser myuser)throws Exception;
    void deleteIssue(Long issueid, Long userid)throws Exception;
    Issue addUserToIssue(Long issueId,Long userId)throws Exception;
    Issue updateStatus(Long issueId,String status)throws Exception;
}
