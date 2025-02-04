package com.test.elibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "borrower")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contact;

    @OneToMany(mappedBy = "borrower", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TransactionEntity> transactions;
}
