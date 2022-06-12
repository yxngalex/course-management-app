package com.metropolitan.coursemanagementapp.service.impl;

import com.metropolitan.coursemanagementapp.entity.Category;
import com.metropolitan.coursemanagementapp.repository.CategoryRepository;
import com.metropolitan.coursemanagementapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NoSuchElementException("CategoryService.notFound"));
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
