package com.demo.projectmanagementsystem.repo;

import com.demo.projectmanagementsystem.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message,Long> {
   List<Message> findByChatIdOrderByCreateAtAsc(Long Chatid);
}
