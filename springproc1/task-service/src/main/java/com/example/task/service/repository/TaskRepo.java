package com.example.task.service.repository;

import com.example.task.service.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task,Long> {
    public List<Task> findByAssignedUserId(Long userId);
}
