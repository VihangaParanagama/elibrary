package com.test.elibrary.repository;

import com.test.elibrary.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity,Long> {
}
