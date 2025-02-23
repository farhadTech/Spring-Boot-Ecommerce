package com.sb_ecommerce.project.service; // Declares the package this class belongs to.

import com.sb_ecommerce.project.model.Category; // Imports the Category model class.
import org.springframework.stereotype.Service; // Imports the @Service annotation for marking this as a service class.

import java.util.ArrayList; // Imports ArrayList from Java's util package for storing category objects.
import java.util.List; // Imports List interface to define the type of collection used.

@Service // Marks this class as a Spring service component, enabling dependency injection.
public class CategoryServiceImpl implements CategoryService {
    // Implements the CategoryService interface, meaning it must define all its methods.

    private final List<Category> categories = new ArrayList<>();
    // Creates a list to store Category objects.
    // This serves as an in-memory storage for categories.

    @Override
    public List<Category> getAllCategories() {
        return categories;
        // Returns the list of all categories.
        // Since this is an in-memory storage, data will be lost when the application restarts.
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
        // Adds a new category to the list.
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
