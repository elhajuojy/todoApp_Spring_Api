package com.elhjuojy.todoapp_spring.repository;

import com.elhjuojy.todoapp_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

}
