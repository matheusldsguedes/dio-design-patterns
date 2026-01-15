package com.projeto.designpatterns.api_pedidos.facade;

import com.projeto.designpatterns.api_pedidos.domain.model.Order;
import com.projeto.designpatterns.api_pedidos.dto.OrderRequestDTO;
import com.projeto.designpatterns.api_pedidos.dto.OrderResponseDTO;
import com.projeto.designpatterns.api_pedidos.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderFacade {
    private final OrderService service;

    public OrderFacade(OrderService service) {
        this.service = service;
    }
    public OrderResponseDTO createOrder(OrderRequestDTO dto){
        Order order = new Order(dto.value());
        Order saved = service.createOrder(order);
        return new OrderResponseDTO(saved.getId(), saved.getValue(), saved.getStatus());
    }
}
