package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Chat;
import com.demo.projectmanagementsystem.model.Message;
import com.demo.projectmanagementsystem.model.MyUserRepository;
import com.demo.projectmanagementsystem.model.Myuser;
import com.demo.projectmanagementsystem.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageserImpl implements MessageService{
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private Projectservice projectservice;
    @Autowired
    private MyUserRepository userRepository;
    @Override
    public Message sendmessage(Long senderid, Long chatid, String content) throws Exception {
        Myuser sendere=userRepository.findById(senderid).orElseThrow(()->new Exception("not found"));

        Chat chat=projectservice.getprojectsbyid(chatid).getChat();
        Message message=new Message();
        message.setContent(content);
        message.setSender(sendere);
        message.setCreatedat(LocalDateTime.now());
        message.setChat(chat);
        Message message1=messageRepo.save(message);
        chat.getMessages().add(message1);
        return message1;
    }

    @Override
    public List<Message> getmessageByProject(long projectid) throws Exception {
        Chat chat=projectservice.getchatbyprojectid(projectid);
        List<Message> findbychat=messageRepo.findByChatIdOrderByCreateAtAsc(chat.getId());
        return findbychat;
    }
}
