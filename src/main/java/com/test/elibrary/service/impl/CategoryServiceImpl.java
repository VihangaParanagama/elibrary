package com.test.elibrary.service.impl;

import com.test.elibrary.dto.CategoryDTO;
import com.test.elibrary.entity.CategoryEntity;
import com.test.elibrary.repository.CategoryRepository;
import com.test.elibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryDTO> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDTO findCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO createCategory(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public boolean deleteCategory(Long id) {
        return false;
    }
}
