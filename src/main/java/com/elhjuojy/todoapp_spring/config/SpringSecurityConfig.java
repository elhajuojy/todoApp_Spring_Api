package com.elhjuojy.todoapp_spring.config;


import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private  final UserRepository userRepository;

    public SpringSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("Enable my Custom Configuration 🦆");

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeHttpRequests(
                (req)->req.requestMatchers("/login/**","/register/").anonymous()
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().authenticated()
        );
        http.formLogin();
        return http.build();
    }

    @Bean
    @Autowired
    public AuthenticationProvider authenticationProvider(@Lazy UserDetailsService userDetailsService, @Lazy PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            User user = userRepository.findByEmail(email);
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            user.getRoles().forEach((role)->{
                authorities.add(new SimpleGrantedAuthority(role.getRoleName().label));
            });
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        };
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        System.out.println("Custom webSecurityCustomizer 😍");
//        //ignore any request that start with /api/**
//        return (web) -> web.ignoring().requestMatchers("/api/**");
//    }


}
