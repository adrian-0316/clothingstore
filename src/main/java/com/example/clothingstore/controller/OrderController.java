package com.example.clothingstore.controller;

import com.example.clothingstore.dto.OrderRequest;
import com.example.clothingstore.dto.OrderResponse;
import com.example.clothingstore.mapper.OrderMapper;
import com.example.clothingstore.model.Order;
import com.example.clothingstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderRequest orderRequest;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderRequest orderRequest, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderRequest = orderRequest;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll(); // Админ
    }

    @GetMapping("/user/{userId}")
    public List<Order> getByUser(@PathVariable Long userId) {
        return orderService.getByUserId(userId); // Для конкретного пользователя
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return orderService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createFromDto(request);
        OrderResponse response = orderMapper.toResponse(order);
        return ResponseEntity.ok(response);
    }
}
