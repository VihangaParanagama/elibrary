package com.test.elibrary.service;

import com.test.elibrary.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDTO addBook(BookDTO   bookDTO);
    BookDTO getBookById(Long bookID);
    List<BookDTO> getAllBook();
    BookDTO updateBook(Long bookID, BookDTO bookDTO);
    boolean deleteBook(Long bookID);
}
