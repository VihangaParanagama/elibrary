package com.test.elibrary.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AuthResponseDTO {
    private String token;

    // Constructor
    public AuthResponseDTO(String token) {
        this.token = token;
    }

    // Getter
    public String getToken() {
        return token;
    }

    // Setter
    public void setToken(String token) {
        this.token = token;
    }
}
