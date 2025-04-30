package com.test.elibrary.controller;

import com.test.elibrary.dto.AuthRequestDTO;
import com.test.elibrary.dto.AuthResponseDTO;
import com.test.elibrary.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService; // Service for handling authentication logic

    // 🔐 Login (JWT Auth) - Authenticate user and generate a JWT token
    @PostMapping("/login") // This maps to /api/auth/login URL path
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        // Calls the AuthService to authenticate the user and generate a JWT token
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
