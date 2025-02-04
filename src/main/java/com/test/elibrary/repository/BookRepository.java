package com.test.elibrary.repository;

import com.test.elibrary.entity.BookEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
