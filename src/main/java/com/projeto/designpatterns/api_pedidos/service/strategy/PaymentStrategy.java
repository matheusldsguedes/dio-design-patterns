package com.projeto.designpatterns.api_pedidos.service.strategy;

import com.projeto.designpatterns.api_pedidos.domain.enums.PaymentType;

import java.math.BigDecimal;

public interface PaymentStrategy {
        boolean pay(BigDecimal amount);
        PaymentType supports();
}
