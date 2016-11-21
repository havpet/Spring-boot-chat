package com.hib.controllers;

import com.hib.entities.Message;
import com.hib.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Message newMessage(Message m) {
        Message message = new Message(m.getContent(), m.getUserId(), m.getName());
        mr.save(message);
        System.out.println("newMessage()");
        return message;
    }

    @RequestMapping(value="/messages", method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        List<Message> messages = mr.findAll();
        return messages;
    }



}
