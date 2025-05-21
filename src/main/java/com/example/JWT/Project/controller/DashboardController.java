package com.example.JWT.Project.controller;

import com.example.JWT.Project.service.UserService;
import com.example.JWT.Project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DashboardController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired private UserService userService;

    @GetMapping("/dashboard")
    public ResponseEntity<String> getDashboard(@RequestHeader("Authorization") String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
        }
        String token = authHeader.substring(7);
        String username = jwtUtil.extractUsername(token);
        if (jwtUtil.validateToken(token, username)) {
            return ResponseEntity.ok("Welcome to the dashboard, " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
        }
    }
}
