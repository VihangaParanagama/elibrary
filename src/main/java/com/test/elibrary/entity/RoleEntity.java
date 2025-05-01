package com.test.elibrary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(nullable = false, unique = true)
    private String name; // Example: "ROLE_ADMIN", "ROLE_USER"

    // Optional: Back-reference to users (not mandatory unless needed)
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude // Prevent circular toString()
    private Set<UserEntity> users;
}
