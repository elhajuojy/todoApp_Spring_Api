package com.elhjuojy.todoapp_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String title ;
    private String body ;
    private LocalDateTime created_date ;
    private LocalDateTime updated_date ;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



}
