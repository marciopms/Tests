package com.example.orderAPI.service;

import com.example.orderAPI.dto.OrderDTO;
import com.example.orderAPI.dto.OrderUpdateDTO;
import com.example.orderAPI.model.Order;
import com.example.orderAPI.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    /* produtor precisa de um tamplate para enviar a informação para o kafka.
       deste template, a chave é string (para apontar o topico) e o valor é um objeto
       (que no caso, quero enviar o pedido alterado).
    * */
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void createOrder(OrderDTO dto) {
        Order order = new Order(dto.orderDescription(), dto.orderStatus(), dto.creationDate());
        orderRepository.save(order);
    }

    public void updateOrders(OrderUpdateDTO dto) {
        Order order = findById(dto.orderId());
        order.setOrderStatus(dto.orderStatus());

        orderRepository.save(order);

        kafkaTemplate.send("topico", "ID: " + order.getOrderId()
                + " Status: " + order.getOrderStatus());
    }

    public Order findById(Long orderId) {
        return orderRepository.getReferenceById(orderId);
    }

    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @KafkaListener(topics = "topico", groupId = "group-1")
    public void OrderConsumer(String message) {
        System.out.println("Informação consumida: \n" + message);
    }
}
