package com.hib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by haava on 11/6/2016.
 */

@Controller
public class ViewController {

    @Autowired
    ChatController chatController;

    @RequestMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage(Model model) {
        return "register";
    }

    @RequestMapping("/chat")
    public String chatPage(Model model, HttpSession session) {
        if(session.getAttribute("id") == null) {
            return "login";
        }
        else {
            model.addAttribute("messages", chatController.getAllMessages());
            return "chat";
        }

    }
}
