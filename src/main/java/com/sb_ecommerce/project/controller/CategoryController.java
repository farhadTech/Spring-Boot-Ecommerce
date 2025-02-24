package com.sb_ecommerce.project.controller;

// Import necessary classes
import com.sb_ecommerce.project.model.Category;
import com.sb_ecommerce.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Constructor injection.
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

    /**
     * Endpoint to retrieve all categories.
     * @return A list of all stored categories.
     */

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List <Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    /**
     * Endpoint to create a new category.
     * @param category The category object sent in the request body.
     * @return A success message.
     */

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<> ("Category created", HttpStatus.CREATED);
    }

    /*
     * We use @PostMapping here because POST requests are used to create new resources on the server.
     * In this case, it allows the client to add a new category.
     */

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
//            return new ResponseEntity<>(status, HttpStatus.OK);
            return ResponseEntity.ok(status);
        } catch(ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        try {
            Category savedCategory = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<> ("Updated Category with category id: " + categoryId, HttpStatus.OK);
        } catch(ResponseStatusException e) {
            return new ResponseEntity<> (e.getReason(), e.getStatusCode());
        }
    }
}





