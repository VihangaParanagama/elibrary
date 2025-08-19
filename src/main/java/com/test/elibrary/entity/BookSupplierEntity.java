package com.test.elibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String contact;
    private boolean active;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "admin_id")
    private AdminEntity adminEntity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "modrator_id")
    private ModeratorEntity moderatorEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookSupplierEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<BookEntity> bookEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "bookSupplierEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<TransactionEntity> transactionEntityList;



}
