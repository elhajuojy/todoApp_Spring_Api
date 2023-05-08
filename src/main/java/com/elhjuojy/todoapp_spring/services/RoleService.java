package com.elhjuojy.todoapp_spring.services;

import com.elhjuojy.todoapp_spring.model.Role;
import com.elhjuojy.todoapp_spring.model.User;

import java.util.Collection;

public interface RoleService {

    Role save(Role user);
    Role update(Role user);
    void delete(Long id);
    Collection<Role> getAll();
}
