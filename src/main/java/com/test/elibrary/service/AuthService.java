package com.test.elibrary.service;

import com.test.elibrary.dto.AuthRequestDTO;
import com.test.elibrary.dto.AuthResponseDTO;
import com.test.elibrary.entity.UserEntity;
import com.test.elibrary.security.JwtService;
import com.test.elibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository; // Repository to fetch user details
    private final JwtService jwtService; // JWT service to generate and validate tokens

    // Method to authenticate the user
    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        // Find the user by username (you might want to handle password hashing and validation here)
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate the password (here just a basic check, consider using bcrypt or another hashing algorithm)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtService.generateToken(user);

        // Return the token in a response DTO
        return new AuthResponseDTO(token);
    }
}