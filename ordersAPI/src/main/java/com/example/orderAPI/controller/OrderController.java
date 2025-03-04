package com.example.orderAPI.controller;

import com.example.orderAPI.dto.OrderDTO;
import com.example.orderAPI.dto.OrderUpdateDTO;
import com.example.orderAPI.model.Order;
import com.example.orderAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    @Transactional
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO dto) {
        orderService.createOrder(dto);
        return ResponseEntity.ok("Pedido criado!");
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> updateStatusOrder(@RequestBody OrderUpdateDTO dto) {
        orderService.updateOrders(dto);
        return ResponseEntity.ok("Status do pedido atualizado!");
    }

    @GetMapping
    public ResponseEntity<List<Order>> listAll() {
        List<Order> orders = orderService.listAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }
}
