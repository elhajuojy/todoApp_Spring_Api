package com.elhjuojy.todoapp_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppSpringApplication.class, args);
	}



	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("Command line runner done 🦆");
			
		};
	}
}
