package com.demo.projectmanagementsystem.service;

import com.demo.projectmanagementsystem.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    Message sendmessage(Long senderid,Long chatid,String content)throws Exception;
    List<Message> getmessageByProject(long  projectid)throws Exception;
}
