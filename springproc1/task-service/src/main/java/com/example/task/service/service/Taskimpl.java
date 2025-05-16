package com.example.task.service.service;

import com.example.task.service.modal.Task;
import com.example.task.service.modal.Teststatus;
import com.example.task.service.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Taskimpl implements TaskService{
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Task createdtask(Task task, String requesterrole) throws Exception {
        if (!requesterrole.equals("ROLE_ADMIN")){
            throw new Exception("only admin can create");
        }
        task.setStatus(Teststatus.PENDING);
        task.setCreateat(LocalDateTime.now());
        return taskRepo.save(task);
    }

    @Override
    public Optional<Task> gettaskbyid(Long id) throws Exception {

        return taskRepo.findById(id);
    }

    @Override
    public List<Task> getalltask(Teststatus status) {
        List<Task> alltask=taskRepo.findAll();
        List<Task> filtertask=alltask.stream().filter(
                task -> status==null || task.getStatus().name().equalsIgnoreCase(status.toString())
        ).collect(Collectors.toList());
        return filtertask;
    }

    @Override
    public Task updateTask(Long id, Task updatetask, Long userid) throws Exception {
     /*  Optional<Task> existtask=gettaskbyid(id);
        if (updatetask.getTitle()!=null){
            existtask.get().setTitle(updatetask.getTitle());
        }
        if (updatetask.getImage()!=null){
            existtask.get().setImage(updatetask.getImage());
        }if (updatetask.getDescription()!=null){
            existtask.get().setDescription(updatetask.getDescription());
        }if (updatetask.getStatus()!=null){
            existtask.get().setStatus(updatetask.getStatus());
        }
        taskRepo.save(existtask);*/
        return null;

    }

    @Override
    public Task deletetask(Long id) throws Exception {
        gettaskbyid(id);
        taskRepo.deleteById(id);

        return null;
    }

    @Override
    public Task assignedtouser(Long userid, Long taskid) throws Exception {
       /* Optional<Task> task=gettaskbyid(taskid);
        task.get().setAssignuserid(userid);
        tas*/
        return null;
    }

    @Override
    public List<Task> assigneduserstask(Long userid, Teststatus statu) {
        return List.of();
    }

    @Override
    public Task completeTask(Long taskid) throws Exception {
        return null;
    }

    @Override
    public Task createdtask(Long id) {
        return null;
    }
}
