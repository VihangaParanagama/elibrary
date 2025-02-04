package com.test.elibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "librarian")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LibrarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "librarian", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserEntity> users;
}
