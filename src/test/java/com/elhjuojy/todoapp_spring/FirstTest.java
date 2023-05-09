package com.elhjuojy.todoapp_spring;

import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class FirstTest{

    @Autowired
    UserRepository userRepository;

    @Test
    void test(){

        Assertions.assertEquals(2,2);

    }

    @Test
    void test1(){
        User user = userRepository.save(new User(null,"user22@test.com","user1","123",new ArrayList<>()));
        Assertions.assertSame(user,user);
    }
}
