package com.elhjuojy.todoapp_spring.controllers;

import com.elhjuojy.todoapp_spring.dto.LoginError;
import com.elhjuojy.todoapp_spring.dto.LoginResponse;
import com.elhjuojy.todoapp_spring.dto.UserCredentials;
import com.elhjuojy.todoapp_spring.model.User;
import com.elhjuojy.todoapp_spring.repository.UserRepository;
import com.elhjuojy.todoapp_spring.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.POST, RequestMethod.GET}
)
public class authController {


    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    public authController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userCredentials.email(), userCredentials.password());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            if (authentication.isAuthenticated()) {
                User user = userRepository.findByEmail(userCredentials.email());
                String accessToken = jwtUtils.generateToken(userDetailsService.loadUserByUsername(userCredentials.email()));
                return ResponseEntity.ok(new LoginResponse(accessToken, user.getUsername(), user.getEmail(), user.getRoles()));
            }
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginError("Invalid email or password", HttpStatus.UNAUTHORIZED));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginError("Invalid email or password", HttpStatus.UNAUTHORIZED));
    }

    @GetMapping("/auth/logged")
    public ResponseEntity<String> logged(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        System.out.println(token);
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            String username = jwtUtils.getUsername(token);
            return ResponseEntity.ok().body("Logged in with : " + username + " using token: " + token);
        }
        return ResponseEntity.ok("Not logged");
    }

}
