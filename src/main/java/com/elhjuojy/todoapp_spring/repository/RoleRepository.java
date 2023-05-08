package com.elhjuojy.todoapp_spring.repository;

import com.elhjuojy.todoapp_spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
