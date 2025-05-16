package com.demo.projectmanagementsystem.Dto;

import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.model.Projects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {
    private Long id;
    private String title;
    private String decription;
    private String status;
    private Long proejctid;
    private String priority;
    private LocalDate duedate;
    private List<String> tags=new ArrayList<>();
    private Myuser assignee;
    private Projects projects;

}
