package com.sb_ecommerce.project.service;

import com.sb_ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component, enabling dependency injection.
public class CategoryServiceImpl implements CategoryService {
    // Implements the CategoryService interface, meaning it must define all its methods.

    private final List<Category> categories = new ArrayList<>();
    // Creates a list to store Category objects.
    // This serves as an in-memory storage for categories.

    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories() {
        return categories;
        // Returns the list of all categories.
        // Since this is an in-memory storage, data will be lost when the application restarts.
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
        // Adds a new category to the list.
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not Found"));

        categories.remove(category);
        return "Category with category Id: " + categoryId + " deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if(optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.");
        }
    }
}

/*
   Summary:
   - This class is a service that handles business logic related to categories.
   - It implements the `CategoryService` interface, ensuring consistency in service method definitions.
   - The @Service annotation registers it as a Spring-managed bean, allowing automatic dependency injection.
   - It currently uses an ArrayList for storage, meaning data is not persistent.
   - In a real application, this would interact with a database via a repository layer.
*/
