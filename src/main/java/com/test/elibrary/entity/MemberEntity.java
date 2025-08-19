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
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private boolean active;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "admin_id")
    private AdminEntity adminEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memberEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<BorrowEntity> borrowEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memberEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<MembershipEntity> membershipEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memberEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<PaymentEntity> paymentEntityList;
}
