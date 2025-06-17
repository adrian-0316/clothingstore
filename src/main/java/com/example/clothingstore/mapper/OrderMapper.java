package com.example.clothingstore.mapper;

import com.example.clothingstore.dto.OrderResponse;
import com.example.clothingstore.model.Order;
import com.example.clothingstore.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderResponse toResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setOrderId(order.getId());
        response.setUserId(order.getUser().getId());
        response.setOrderDate(order.getOrderDate());
        response.setStatus(order.getStatus());

        List<OrderResponse.Item> itemList = order.getItems().stream().map(this::mapItem).toList();
        response.setItems(itemList);

        return response;
    }

    private OrderResponse.Item mapItem(OrderItem item) {
        OrderResponse.Item dto = new OrderResponse.Item();
        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getProduct().getPrice());
        return dto;
    }
}
