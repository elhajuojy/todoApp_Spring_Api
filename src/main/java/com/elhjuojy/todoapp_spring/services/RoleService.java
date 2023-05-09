package com.elhjuojy.todoapp_spring.services;

import com.elhjuojy.todoapp_spring.enums.RoleEnum;
import com.elhjuojy.todoapp_spring.model.Role;
import com.elhjuojy.todoapp_spring.model.User;

import java.util.Collection;

public interface RoleService {

    Role save(Role role);
    Role update(Role role);
    void delete(Long id);
    Collection<Role> getAll();
    Role loadByRoleName(RoleEnum roleName);
    public void addRoleToUser(String email , RoleEnum roleName);
}
