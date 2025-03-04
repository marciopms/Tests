package com.example.orderAPI.model;

import com.example.orderAPI.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
/*
    Aparentemente o hibernate está bloqueando por padrão retonar as classes diretamente no get.
    O ideal seria criar um DTO para retornar as informações, mas para fins de testes, adiciona-se
    esta anotação para ignorar esta validação.
* */
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column
    private String orderDescription;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Column
    private LocalDate creationDate;

    public Order() {}

    public Order(String orderDescription, OrderStatus orderStatus, LocalDate creationDate) {
        this.orderDescription = orderDescription;
        this.orderStatus = orderStatus;
        this.creationDate = creationDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
