package com.hib.controllers;

import com.hib.entities.Message;
import com.hib.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Håvard on 11/16/2016.
 */

@Controller
@RequestMapping("chat")
public class ChatController {

    @Autowired
    private MessageRepository mr;

    @RequestMapping(value="/newMessage", method = RequestMethod.POST)
    public void newMessage(HttpServletResponse response, HttpSession session, String content) {
        if(session.getAttribute("id") != null) {
            Message message = new Message(content, (Long) session.getAttribute("id"), (String) session.getAttribute("user"));
            mr.save(message);
            try {
                response.sendRedirect("/chat");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

        else {
            try {
                response.sendRedirect("/login");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    @RequestMapping(value="/getAll", method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        List<Message> messages = mr.findAll();
        return messages;
    }



}
