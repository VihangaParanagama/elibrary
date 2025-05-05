package com.test.elibrary.service;

import com.test.elibrary.dto.CategoryDTO;
import com.test.elibrary.entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO findCategoryById(Long id);
    CategoryDTO createCategory(CategoryEntity categoryEntity);
    CategoryDTO updateCategory(Long id, CategoryEntity categoryEntity);
    boolean deleteCategory(Long id);
}
