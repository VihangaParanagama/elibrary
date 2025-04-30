package com.test.elibrary.service.impl;

import com.test.elibrary.dto.BookDTO;
import com.test.elibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorroweServiceImpl implements BookService {
    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        return null;
    }

    @Override
    public BookDTO getBookById(Long bookID) {
        return null;
    }

    @Override
    public List<BookDTO> getAllBook() {
        return null;
    }

    @Override
    public BookDTO updateBook(Long bookID, BookDTO bookDTO) {
        return null;
    }

    @Override
    public boolean deleteBook(Long bookID) {
        return false;
    }
}
