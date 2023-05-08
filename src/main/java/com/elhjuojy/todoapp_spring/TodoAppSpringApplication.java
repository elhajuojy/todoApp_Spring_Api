package com.elhjuojy.todoapp_spring;

import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.services.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class TodoAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppSpringApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(UserServiceImpl userService){
		return args -> {
			System.out.println("Command line runner done 🦆");
			userService.save(new User(null,"user1@test.com","user1","123",new ArrayList<>()));
			userService.save(new User(null,"user2@test.com","user2","123",new ArrayList<>()));
			userService.save(new User(null,"user3@test.com","user3","123",new ArrayList<>()));
			userService.save(new User(null,"user4@test.com","user4","123",new ArrayList<>()));

		};
	}
}
