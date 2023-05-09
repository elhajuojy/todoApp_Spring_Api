package com.elhjuojy.todoapp_spring.controllers;


import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.services.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PostMapping("/addRole")
    public User addRole(){
        return  null;
    }


}
