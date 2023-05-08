package com.elhjuojy.todoapp_spring.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
public class todoController {

      public String getAll(){
          return "all todos";
      }

}
