package com.test.elibrary.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BorrowedResponseDTO {
    private Long borrowId;
    private Long userId;
    private String userName;
    private Long bookId;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private String status;

//    public BorrowedResponseDTO(Long borrowId, Long userId, String userName, Long bookId, String bookTitle, LocalDate borrowDate, LocalDate returnDate, String status) {
//        this.borrowId = borrowId;
//        this.userId = userId;
//        this.userName = userName;
//        this.bookId = bookId;
//        this.bookTitle = bookTitle;
//        this.borrowDate = borrowDate;
//        this.returnDate = returnDate;
//        this.status = status;
//    }
}