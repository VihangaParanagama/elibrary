package com.test.elibrary.service.impl;

import com.test.elibrary.dto.AuthRequestDTO;
import com.test.elibrary.dto.AuthResponseDTO;
import com.test.elibrary.entity.UserEntity;
import com.test.elibrary.repository.UserRepository;
import com.test.elibrary.security.JwtService;
import com.test.elibrary.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Spring-managed bean
@RequiredArgsConstructor // Automatically generates constructor for dependencies
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository; // Repository to fetch user details
    private final JwtService jwtService; // JWT service to generate and validate tokens

    // Method to authenticate the user
    @Override
    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        // Find the user by username
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Validate the password (You might want to use bcrypt or another hashing method here)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        String token = jwtService.generateToken(user);

        // Return the token in a response DTO
        return new AuthResponseDTO(token);
    }
}
