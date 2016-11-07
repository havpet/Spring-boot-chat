package com.hib.controllers;

import com.hib.entities.User;
import com.hib.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by haava on 11/3/2016.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository ur;

    @RequestMapping("/getUsers")
    public Collection<User> getAllUsers() {
        return ur.findAll();
    }
    @RequestMapping("/addUser")
    public void addUser() {
        User user = new User(100L, "ha@havpet.no", "Haavard", "abba");
        ur.save(user);
    }

}
