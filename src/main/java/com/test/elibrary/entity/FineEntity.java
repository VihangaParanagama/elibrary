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
public class FineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fineEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<BorrowEntity> borrowEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fineEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<PaymentEntity> paymentEntityList;
}
