package com.test.elibrary.repository;

import com.test.elibrary.entity.BorrowerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorroweRepository extends JpaRepository<BorrowerEntity,Long> {
}
