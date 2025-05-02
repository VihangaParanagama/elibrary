package com.test.elibrary.repository;

import com.test.elibrary.entity.CategoryEntity;
import com.test.elibrary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByCategoryName(String categoryName);
}
