package com.sb_ecommerce.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

/* Entity represents a table in JPA, Earlier it was POJO(Plain Old Java Object, now it becomes entity.
* Every Entity must inherit one @Embedded Id */

@Entity(name = "Categories") // changing table name
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;

    public Category() {}
    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
