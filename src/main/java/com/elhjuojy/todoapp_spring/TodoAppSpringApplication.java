package com.elhjuojy.todoapp_spring;

import com.elhjuojy.todoapp_spring.enums.RoleEnum;
import com.elhjuojy.todoapp_spring.model.Role;
import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.services.impl.RoleServiceImpl;
import com.elhjuojy.todoapp_spring.services.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TodoAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppSpringApplication.class, args);
	}




	@Bean
	CommandLineRunner commandLineRunner(UserServiceImpl userService, RoleServiceImpl roleService){
		return args -> {
			System.out.println("Command line runner done 🦆");

			// Add new users
			userService.save(new User(null,"user1@test.com","user1","123",new ArrayList<>()));
			userService.save(new User(null,"user2@test.com","user2","123",new ArrayList<>()));
			userService.save(new User(null,"user3@test.com","user3","123",new ArrayList<>()));
			userService.save(new User(null,"user4@test.com","user4","123",new ArrayList<>()));

			// ADD new  ROLES
			roleService.save(new Role(null, RoleEnum.ADMIN));
			roleService.save(new Role(null, RoleEnum.MANAGER));
			roleService.save(new Role(null, RoleEnum.PRODUCT_MANAGER));
			roleService.save(new Role(null, RoleEnum.CUSTOMER_MANAGER));
			roleService.save(new Role(null, RoleEnum.USER));

			// Add roles to users

			roleService.addRoleToUser("user1@test.com",RoleEnum.MANAGER);
			roleService.addRoleToUser("user1@test.com",RoleEnum.USER);
			roleService.addRoleToUser("user2@test.com",RoleEnum.ADMIN);
			roleService.addRoleToUser("user3@test.com",RoleEnum.PRODUCT_MANAGER);
			roleService.addRoleToUser("user4@test.com",RoleEnum.CUSTOMER_MANAGER);








		};
	}



}
