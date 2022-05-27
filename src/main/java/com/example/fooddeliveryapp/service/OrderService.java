package com.example.fooddeliveryapp.service;

import com.example.fooddeliveryapp.module.Order;
import com.example.fooddeliveryapp.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
}
