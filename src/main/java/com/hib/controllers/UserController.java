package com.hib.controllers;

import com.hib.entities.User;
import com.hib.repositories.UserRepository;
import com.hib.tools.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by haava on 11/3/2016.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository ur;

    @RequestMapping("/getUsers")
    public Collection<User> getAllUsers() {
        return ur.findAll();
    }

    @RequestMapping(value="/register")
    public void register(HttpServletResponse response, String email, String name, String password) {
        try {
            if(ur.findByEmail(email) == null) {
                User user = new User(email, name, Security.encrypt(password));
                ur.save(user);
                response.sendRedirect("/login");
            }

            else {
                response.sendRedirect("/register");
            }
        }

        catch(Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void login(HttpSession session, HttpServletResponse response, String email, String password) {
        User user = ur.findByEmail(email);
        try {
            if(user != null) {
                String encryptedPassword = user.getPassword();
                if(Security.matches(password, encryptedPassword)) {
                    session.setAttribute("user", user.getName());
                    response.sendRedirect("/chat");
                }
                else {
                    response.sendRedirect("/login");
                }
            }
            else {
                response.sendRedirect("/login");
            }
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
