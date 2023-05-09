package com.elhjuojy.todoapp_spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("Enable my Custom Configuration 🦆");

        http.authorizeHttpRequests(

        ).anyRequest().authenticated();
        http.formLogin();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        System.out.println("Custom webSecurityCustomizer 😍");
        //ignore any request that start with /api/**
        return (web) -> web.ignoring().requestMatchers("/api/**");
    }
}
