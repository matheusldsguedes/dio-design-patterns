package com.projeto.designpatterns.api_pedidos.service;

import com.projeto.designpatterns.api_pedidos.domain.model.Order;
import com.projeto.designpatterns.api_pedidos.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import com.projeto.designpatterns.api_pedidos.exception.OrderException;

@Service
public class OrderService {
    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
    public Order createOrder(Order order){
        return repository.save(order);
    }
    public Order searchById(Long id){
        return repository.findById(id).orElseThrow(() -> new OrderException("Order not found"));
    }
}
