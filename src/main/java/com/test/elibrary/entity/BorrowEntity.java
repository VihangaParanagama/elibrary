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
public class BorrowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Integer dueDate;
    private Double total;
    private String isReturn;

    private String memberName;
    private String bookName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Member_id",nullable = false)
    private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Book_id",nullable = false)
    private BookEntity bookEntity;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "borrowEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<FineEntity> fineEntityList;
}
