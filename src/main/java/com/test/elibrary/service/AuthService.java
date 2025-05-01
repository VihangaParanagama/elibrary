package com.test.elibrary.service;

import com.test.elibrary.dto.AuthRequestDTO;
import com.test.elibrary.dto.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO authenticate(AuthRequestDTO request);
}
