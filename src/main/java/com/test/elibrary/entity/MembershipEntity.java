package com.test.elibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean paid;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "membershipEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<MemberEntity> memberEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "membershipEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<PaymentEntity> paymentEntityList;
}
