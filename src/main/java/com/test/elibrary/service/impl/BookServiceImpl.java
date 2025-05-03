package com.test.elibrary.service.impl;

import com.test.elibrary.dto.BookDTO;
import com.test.elibrary.dto.BorrowedResponseDTO;
import com.test.elibrary.entity.BookEntity;
import com.test.elibrary.entity.CategoryEntity;
import com.test.elibrary.repository.BookRepository;
import com.test.elibrary.repository.CategoryRepository;
import com.test.elibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BookEntity addBook(BookDTO bookDTO) {
        BookEntity newBookEntity = new BookEntity();
        newBookEntity.setBookId(bookDTO.getId());
        newBookEntity.setTitle(bookDTO.getCategory());
        newBookEntity.setAuthor(bookDTO.getAuthor());
        newBookEntity.setAvailableCopies(bookDTO.getAvailableCopies());

        return bookRepository.save(newBookEntity);


    }

    @Override
    public BookEntity getBookById(Long bookID) {
        return bookRepository.findById(bookID).orElse(null);
    }

    @Override
    public List<BookEntity> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public BookEntity updateBook(Long bookID, BookDTO bookDTO) {
        Optional<BookEntity> existingBookOpt = bookRepository.findById(bookID);
        if (existingBookOpt.isPresent()) {
            BookEntity existingBook = existingBookOpt.get();
            existingBook.setTitle(bookDTO.getTitle());
            existingBook.setAuthor(bookDTO.getAuthor());

            CategoryEntity category = categoryRepository.findByCategoryName(bookDTO.getCategory())
                    .orElseThrow(() -> new RuntimeException("Category not found: " + bookDTO.getCategory()));
            existingBook.setCategory(category);

            existingBook.setAvailableCopies(bookDTO.getAvailableCopies());

            return bookRepository.save(existingBook);
        } else {
            throw new RuntimeException("Book not found with ID: " + bookID);
        }
    }

    @Override
    public boolean deleteBook(Long bookID) {
        if (bookRepository.existsById(bookID)) {
            bookRepository.deleteById(bookID);
            return true;
        } else {
            return false;
        }
    }
}
