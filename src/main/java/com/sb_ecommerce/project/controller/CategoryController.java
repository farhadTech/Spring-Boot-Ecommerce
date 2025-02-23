package com.sb_ecommerce.project.controller;

// Import necessary classes
import com.sb_ecommerce.project.model.Category;
import com.sb_ecommerce.project.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is a Spring Boot REST controller that handles HTTP requests related to categories.
 * It provides endpoints to retrieve all categories and add a new category.
 */
@RestController // Marks this class as a REST controller, meaning it handles HTTP requests.
public class CategoryController {
    private final CategoryService categoryService;

    // Constructor injection.
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Endpoint to retrieve all categories.
     * @return A list of all stored categories.
     */

    @GetMapping("/api/public/categories") // Maps HTTP GET requests to this method.
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories(); // Returns the list of categories as a JSON response.
    }

    /**
     * Endpoint to create a new category.
     * @param category The category object sent in the request body.
     * @return A success message.
     */

    @PostMapping("/api/public/categories") // Maps HTTP POST requests to this method.
    public String createCategory(@RequestBody Category category) {
        categoryService.createCategory(category); // Adds the received category object to the list.
        return "Category added successfully."; // Returns a success message.
    }

    /*
     * We use @PostMapping here because POST requests are used to create new resources on the server.
     * In this case, it allows the client to add a new category.
     */

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }
}
