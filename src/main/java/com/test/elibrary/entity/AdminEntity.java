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
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String productKey;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adminEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<ModeratorEntity> moderatorEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adminEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<MemberEntity> memberEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adminEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<BookSupplierEntity> bookSupplierEntities;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adminEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<AuditLogEntity> auditLogEntityList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adminEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<NotificationEntity> notificationEntities;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adminEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<TransactionEntity> transactionEntityList;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "superAdminEntity")
//    @JsonIgnore
//    @ToString.Exclude
//    private List<BorrowEntity> borrowEntityList;


}
