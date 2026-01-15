package com.projeto.designpatterns.api_pedidos.dto;

import com.projeto.designpatterns.api_pedidos.domain.enums.OrderStatus;
import com.projeto.designpatterns.api_pedidos.domain.model.Order;

import java.math.BigDecimal;

public record OrderResponseDTO (Long id, BigDecimal value, OrderStatus status){
    public static OrderResponseDTO from(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getValue(),
                order.getStatus()
        );
    }
}
