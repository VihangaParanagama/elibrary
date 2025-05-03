package com.test.elibrary.service;

import com.test.elibrary.dto.BookDTO;
import com.test.elibrary.dto.BorrowedResponseDTO;
import com.test.elibrary.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookEntity addBook(BookDTO bookDTO);
    BookEntity getBookById(Long bookID);
    List<BookEntity> getAllBook();
    BookEntity updateBook(Long bookID, BookDTO  bookDTO);
    boolean deleteBook(Long bookID);
}
