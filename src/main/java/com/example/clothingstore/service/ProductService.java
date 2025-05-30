package com.example.clothingstore.service;

import com.example.clothingstore.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> getByCategory(Long categoryId);
}
