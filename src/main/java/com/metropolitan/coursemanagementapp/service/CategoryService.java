package com.metropolitan.coursemanagementapp.service;

import com.metropolitan.coursemanagementapp.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Integer categoryId);

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteById(Integer categoryId);

}
