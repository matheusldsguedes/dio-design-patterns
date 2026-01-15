package com.projeto.designpatterns.api_pedidos.dto;

import com.projeto.designpatterns.api_pedidos.domain.enums.OrderStatus;

import java.math.BigDecimal;

public record OrderResponseDTO (Long id, BigDecimal value, OrderStatus status){
}
