package com.example.orderAPI.dto;

import com.example.orderAPI.enums.OrderStatus;

import java.time.LocalDate;

public record OrderDTO(String orderDescription, OrderStatus orderStatus, LocalDate creationDate) {
}
