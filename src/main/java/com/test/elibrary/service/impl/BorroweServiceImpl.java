package com.test.elibrary.service.impl;

import com.test.elibrary.dto.BorrowedRequestDTO;
import com.test.elibrary.dto.BorrowedResponseDTO;
import com.test.elibrary.entity.BookEntity;
import com.test.elibrary.entity.BorrowedBookEntity;
import com.test.elibrary.entity.UserEntity;
import com.test.elibrary.mapper.BorrowedBookMapper;
import com.test.elibrary.repository.BookRepository;
import com.test.elibrary.repository.BorrowRepository;
import com.test.elibrary.repository.UserRepository;
import com.test.elibrary.service.BorrowedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BorroweServiceImpl implements BorrowedService {
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final BorrowedBookMapper borrowedBookMapper;


    @Override
    public BorrowedResponseDTO borrowBook(BorrowedRequestDTO requestDTO) {
        UserEntity userEntity = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        BookEntity book = bookRepository.findById(requestDTO.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("Book is not available for borrowing");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        BorrowedBookEntity borrowedBookEntity = new BorrowedBookEntity();
        borrowedBookEntity.setUser(userEntity);
        borrowedBookEntity.setBook(book);
        borrowedBookEntity.setBorrowDate(LocalDate.now());
        borrowedBookEntity.setReturnDate(requestDTO.getReturnDate());
        borrowedBookEntity.setStatus("Borrowed");

        borrowRepository.save(borrowedBookEntity);
        bookRepository.save(book);


        return new BorrowedResponseDTO(
                borrowedBookEntity.getBorrowId(),
                userEntity.getId(),
                userEntity.getUsername(),
                book.getBookId(),
                book.getTitle(),
                borrowedBookEntity.getBorrowDate(),
                borrowedBookEntity.getReturnDate(),
                borrowedBookEntity.getStatus()
        );
    }


    @Override
    public BorrowedResponseDTO returnBook(Long borrowId) {
        return null;
    }

    @Override
    public BorrowedResponseDTO extendDueDate(Long borrowId, int extraDays) {
        return null;
    }

    @Override
    public List<BorrowedResponseDTO> getAllBorrowedBooks() {
        return null;
    }

    @Override
    public List<BorrowedResponseDTO> getBorrowedBooksByUserId(Long userId) {
        return borrowedBookMapper.toDtoList(borrowRepository.findAll());
    }

    @Override
    public boolean isBookCurrentlyBorrowed(Long bookId) {

        return false;
    }

    @Override
    public double calculateFine(Long borrowId) {
        return 0;
    }

    @Override
    public void deleteBorrowingRecord(Long borrowId) {
        borrowRepository.deleteById(borrowId);
    }
}
