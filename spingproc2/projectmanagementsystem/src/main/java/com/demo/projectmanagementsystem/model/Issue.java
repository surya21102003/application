package com.demo.projectmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String decription;
    private String status;
    private Long proejctid;
    private String priority;
    private LocalDate duedate;
    private List<String> tags=new ArrayList<>();


    @ManyToOne
    private Myuser assignee;

    @JsonIgnore
    @ManyToOne()
    private Projects projects;

    @JsonIgnore
    @OneToMany(mappedBy = "issue",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comments>comments=new ArrayList<>();


}
