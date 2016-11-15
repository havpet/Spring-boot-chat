package com.hib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by haava on 11/6/2016.
 */

@Controller
public class ViewController {

    @RequestMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @RequestMapping("/register")
    public String registerPage(Model model) {
        return "register";
    }

    @RequestMapping("/chat")
    public String chatPage(Model model) {
        return "chat";
    }
}
