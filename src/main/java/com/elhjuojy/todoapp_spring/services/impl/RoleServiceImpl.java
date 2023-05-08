package com.elhjuojy.todoapp_spring.services.impl;

import com.elhjuojy.todoapp_spring.enums.RoleEnum;
import com.elhjuojy.todoapp_spring.model.Role;
import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.repository.RoleRepository;
import com.elhjuojy.todoapp_spring.repository.UserRepository;
import com.elhjuojy.todoapp_spring.services.RoleService;
import com.elhjuojy.todoapp_spring.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role update(Role user) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Role role = this.roleRepository.findById(id).orElseThrow();
        this.roleRepository.delete(role);
    }

    @Override
    public Collection<Role> getAll() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role loadByRoleName(RoleEnum roleName) {
        return this.roleRepository.findByRoleName(roleName);
    }
}
