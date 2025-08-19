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
public class AuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actorId;
    private String actorRole;
    private LocalDateTime localDateTime;
    private String entityAffected;//book,money,booksupplier
    private String acion; //add,remove,update
    private Double amount;
    private String transactionType;//FINE, MEMBERSHIP, OTHER
    private String status;//SUCCESS, FAILED, PENDING, CANCELLED

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentEntity paymentEntity;
}
