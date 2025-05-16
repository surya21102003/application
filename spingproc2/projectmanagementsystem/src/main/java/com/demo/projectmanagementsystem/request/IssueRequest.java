package com.demo.projectmanagementsystem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueRequest {
    private String title;
    private String decription;
    private String status;
    private Long proejctid;
    private String priority;
    private LocalDate duedate;

}
