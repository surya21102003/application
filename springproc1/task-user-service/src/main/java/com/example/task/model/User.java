package com.example.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
     private String fullname;
     private String password;
     private String email;
     private String role;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getFullname() {
          return fullname;
     }

     public void setFullname(String fullname) {
          this.fullname = fullname;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getRole() {
          return role;
     }

     public void setRole(String role) {
          this.role = role;
     }
}
