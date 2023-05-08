package com.elhjuojy.todoapp_spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class FirstTest{

    @Test
    void test(){
        
        Assertions.assertEquals(2,2);

    }
}
