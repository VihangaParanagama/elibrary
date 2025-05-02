package com.test.elibrary.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Set<String> roles;
}

