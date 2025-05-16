package com.example.task.service.service;

import com.example.task.service.modal.Task;
import com.example.task.service.modal.Teststatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    Task createdtask(Task task,String requesterrole)throws Exception;
    Optional<Task> gettaskbyid(Long id)throws Exception;
    List<Task> getalltask(Teststatus status);
    Task updateTask(Long id,Task updatetask,Long userid)throws Exception;
    Task deletetask(Long id) throws Exception;
    Task assignedtouser(Long userid,Long taskid)throws Exception;
    List<Task>  assigneduserstask(Long userid,Teststatus statu);
    Task completeTask(Long taskid)throws Exception;

    Task createdtask(Long id);
}
