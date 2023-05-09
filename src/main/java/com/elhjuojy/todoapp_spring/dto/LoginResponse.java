package com.elhjuojy.todoapp_spring.dto;


import com.elhjuojy.todoapp_spring.model.Role;

import java.util.Collection;

public record LoginResponse(String token, String username, String email, Collection<Role> roles) {
}