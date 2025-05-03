package com.test.elibrary.service;

import com.test.elibrary.dto.BorrowedRequestDTO;
import com.test.elibrary.dto.BorrowedResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowedService {
    BorrowedResponseDTO borrowBook(BorrowedRequestDTO requestDTO);

    BorrowedResponseDTO returnBook(Long borrowId);

    BorrowedResponseDTO extendDueDate(Long borrowId, int extraDays);

    List<BorrowedResponseDTO> getAllBorrowedBooks();

    List<BorrowedResponseDTO> getBorrowedBooksByUserId(Long userId);

    boolean isBookCurrentlyBorrowed(Long bookId);

    double calculateFine(Long borrowId);

    void deleteBorrowingRecord(Long borrowId);
}
