package com.elhjuojy.todoapp_spring.dto;

import org.springframework.http.HttpStatus;

public record LoginError(String message, HttpStatus status) {
}