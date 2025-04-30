package com.test.elibrary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthRequestDTO {
    private String username;
    private String password;
}
