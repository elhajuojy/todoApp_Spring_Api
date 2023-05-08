package com.elhjuojy.todoapp_spring.services.impl;

import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.repository.UserRepository;
import com.elhjuojy.todoapp_spring.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private  UserRepository userRepository;


    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User user1 = this.userRepository.findByEmail(user.getEmail());

        if (user1 !=null){
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
          return  this.userRepository.save(user1);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(user);

    }

    @Override
    public Collection<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User loadByUserName(String username) {
        return null;
    }

    @Override
    public User loadByUserEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
