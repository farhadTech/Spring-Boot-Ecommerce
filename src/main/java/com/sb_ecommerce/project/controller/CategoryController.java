package com.sb_ecommerce.project.controller;

// Import necessary classes
import com.sb_ecommerce.project.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Spring Boot REST controller that handles HTTP requests related to categories.
 * It provides endpoints to retrieve all categories and add a new category.
 */
@RestController // Marks this class as a REST controller, meaning it handles HTTP requests.
public class CategoryController {

    // A list to store category objects (acting as an in-memory database for now).
    private List<Category> categories = new ArrayList<Category>();

    /**
     * Endpoint to retrieve all categories.
     * @return A list of all stored categories.
     */
    @GetMapping("/api/public/categories") // Maps HTTP GET requests to this method.
    public List<Category> getAllCategories() {
        return categories; // Returns the list of categories as a JSON response.
    }

    /**
     * Endpoint to create a new category.
     * @param category The category object sent in the request body.
     * @return A success message.
     */
    @PostMapping("/api/public/categories") // Maps HTTP POST requests to this method.
    public String createCategory(@RequestBody Category category) {
        categories.add(category); // Adds the received category object to the list.
        return "Category added successfully."; // Returns a success message.
    }

    /*
     * We use @PostMapping here because POST requests are used to create new resources on the server.
     * In this case, it allows the client to add a new category.
     */
}
