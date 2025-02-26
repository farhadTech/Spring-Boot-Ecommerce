package com.sb_ecommerce.project.service;

import com.sb_ecommerce.project.model.Category;
import com.sb_ecommerce.project.payload.CategoryDTO;
import com.sb_ecommerce.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO category);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}