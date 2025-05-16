package com.demo.projectmanagementsystem.request;

import com.demo.projectmanagementsystem.model.Issue;
import com.demo.projectmanagementsystem.model.Myuser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCommentRequest {

    private Long issueid;

    private String Content;


}
