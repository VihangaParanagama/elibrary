package com.test.elibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Member_id",nullable = false)
    private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Membership_id",nullable = false)
    private MembershipEntity membershipEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "paymentEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<FineEntity> fineEntityList;
}
