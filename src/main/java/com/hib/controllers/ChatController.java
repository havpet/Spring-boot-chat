package com.hib.controllers;

import com.hib.entities.Message;
import com.hib.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Håvard on 11/16/2016.
 */

@RestController
public class ChatController {

    @Autowired
    private MessageRepository mr;

    @RequestMapping(value="/messages", method=RequestMethod.POST)
    @MessageMapping("/newMessage")
    @SendTo("/topic/newMessage")
    public List<Message> newMessage(SimpMessageHeaderAccessor headerAccessor, String content) {
        Map<String, Object> attrs = headerAccessor.getSessionAttributes();
        Message message = new Message(content, (Long) attrs.get("id"), (String) attrs.get("user"));
        mr.save(message);



        List<Message> messages = mr.findAll();
        return messages;
    }

    @RequestMapping(value="/messages", method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        List<Message> messages = mr.findAll();
        return messages;
    }



}
