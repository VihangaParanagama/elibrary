package com.test.elibrary.repository;

import com.test.elibrary.entity.BorrowedBookEntity;
import com.test.elibrary.entity.BorrowedBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowedBookEntity, Long> {
}
