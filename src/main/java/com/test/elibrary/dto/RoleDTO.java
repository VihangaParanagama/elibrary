package com.test.elibrary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleDTO {
    private Long id;
    private String name; // Role name like "ADMIN", "LIBRARIAN"
}
