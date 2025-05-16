package com.example.task.service.controller;

import com.example.task.service.modal.Task;
import com.example.task.service.modal.Teststatus;
import com.example.task.service.modal.Userdto;
import com.example.task.service.service.TaskService;
import com.example.task.service.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    private Userservice userservice;

    @PostMapping()
    public ResponseEntity<Task> createtask(@RequestBody Task task, @RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
        Task createdtask=taskService.createdtask(task,user.getRole());
System.out.println("createtask");
        return new ResponseEntity<>(createdtask, HttpStatus.CREATED);
    }
@GetMapping("/{id}/getting")
    public ResponseEntity<Task> gettaskbyid(@PathVariable Long id,@RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
        Optional<Task> createdtask=taskService.gettaskbyid(id);
    System.out.println("gettaskbyid");

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
    @GetMapping("/user")
    public ResponseEntity<Task> getalltask(@RequestParam(required = false)Teststatus status, @RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
        Task createdtask= (Task) taskService.getalltask(status);
        System.out.println("getalltask");

        return new ResponseEntity<>(createdtask, HttpStatus.CREATED);
    }
    @PutMapping("/{id}/user/{userid}/assigned")
    public ResponseEntity<Task> assignedtasktouser(@PathVariable Long id,@PathVariable Long userid, @RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
        Task createdtask= (Task) taskService.assignedtouser(userid,id);
        System.out.println("assignedtasktouser");

        return new ResponseEntity<>(createdtask, HttpStatus.CREATED);
    }
    @PutMapping("/{id}/updateing")
    public ResponseEntity<Task> updatetaskt(@PathVariable Long id,@RequestBody Task req, @RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
        Task createdtask= (Task) taskService.updateTask(id,req, user.getId());
        System.out.println("updatetaskt");

        return new ResponseEntity<>(createdtask, HttpStatus.OK);
    }
    @PutMapping("/{id}/complete")
    public ResponseEntity<Task> completetaskt(@PathVariable Long id,@RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
        Task createdtask=  taskService.createdtask(id);
        System.out.println("completetaskt");


         return new ResponseEntity<>(createdtask, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deletetaskt(@PathVariable Long id,@RequestHeader("Authorization") String jwt) throws Exception {
        Userdto user=userservice.getuserprofile(jwt);
         taskService.deletetask(id);
        System.out.println("deletetaskt");

        return new ResponseEntity<>(null, HttpStatus.OK);

    }




}
