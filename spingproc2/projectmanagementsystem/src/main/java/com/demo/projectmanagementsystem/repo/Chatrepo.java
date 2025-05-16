package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Chatrepo extends JpaRepository<Chat,Long> {
}
