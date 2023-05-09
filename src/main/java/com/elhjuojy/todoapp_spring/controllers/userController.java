package com.elhjuojy.todoapp_spring.controllers;


import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/users")
public class userController {

    private final UserServiceImpl userService;

    public userController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public Collection<User> index(){
        return  this.userService.getAll();
    }

    @PostMapping("/addRole")
    public User addRole(){
        return  null;
    }


}
