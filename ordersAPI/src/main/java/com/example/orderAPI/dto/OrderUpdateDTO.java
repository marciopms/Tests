package com.example.orderAPI.dto;

import com.example.orderAPI.enums.OrderStatus;

public record OrderUpdateDTO(Long orderId, OrderStatus orderStatus) {
}
