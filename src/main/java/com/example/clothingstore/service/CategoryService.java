package com.example.clothingstore.service;

import com.example.clothingstore.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();
    Optional<Category> getById(Long id);
    Category save(Category category);
    void deleteById(Long id);
}
