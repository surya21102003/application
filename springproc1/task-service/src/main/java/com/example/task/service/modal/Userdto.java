package com.example.task.service.modal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {
    private Long id;
    private String fullname;
    private String password;
    private String email;
    private String role;

}
