package com.demo.projectmanagementsystem.Controller;

import com.demo.projectmanagementsystem.model.Chat;
import com.demo.projectmanagementsystem.model.Message;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.request.MessageReq;
import com.demo.projectmanagementsystem.service.MessageService;
import com.demo.projectmanagementsystem.service.Projectservice;
import com.demo.projectmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private Projectservice projectservice;

    @PostMapping("/send")
    public ResponseEntity<Message> sendmessage(@RequestBody MessageReq req)throws Exception{
        Myuser user=userService.finduserbyid(req.getSenderid());
        if (user==null)throw  new Exception("not found");
        Chat chat=projectservice.getprojectsbyid(req.getProjectid()).getChat();
        if (chat==null)throw new Exception("not found");
        Message message=messageService.sendmessage(req.getSenderid(), req.getProjectid(),  req.getContent());
        return ResponseEntity.ok(message);
    }
    @GetMapping("/chat/{projectid}")
    public ResponseEntity<List<Message>> getmessage(@PathVariable Long projectid)throws Exception{
        List<Message> messages=messageService.getmessageByProject(projectid);
        return ResponseEntity.ok(messages);
    }
}
