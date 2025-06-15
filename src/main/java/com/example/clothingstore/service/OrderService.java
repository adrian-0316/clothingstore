package com.example.clothingstore.service;

import com.example.clothingstore.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAll();
    List<Order> getByUserId(Long userId);
    Optional<Order> getById(Long id);
    Order save(Order order);
    void deleteById(Long id);
}
