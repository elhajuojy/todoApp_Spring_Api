package com.elhjuojy.todoapp_spring.services;

import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserService {
    User save(User user);
    User update(User user);
    void delete(Long id);
    Collection<User> getAll();
    User loadByUserName(String username);
    User loadByUserEmail(String email);


}
