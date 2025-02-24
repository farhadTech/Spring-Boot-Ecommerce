package com.sb_ecommerce.project.service;

import com.sb_ecommerce.project.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}

/*
   Summary:
   - This interface defines two methods: one to fetch all categories and another to add a new category.
   - Any class that implements this interface must provide concrete implementations for these methods.
   - This follows the Dependency Inversion Principle(Loose coupling); In here we are achieving dip through constructor injection,
    allowing flexibility in the service layer.
*/
