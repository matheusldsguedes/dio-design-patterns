package com.projeto.designpatterns.api_pedidos.service;

import com.projeto.designpatterns.api_pedidos.domain.enums.PaymentType;
import com.projeto.designpatterns.api_pedidos.domain.model.Order;
import com.projeto.designpatterns.api_pedidos.service.strategy.PaymentStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    private final Map<PaymentType, PaymentStrategy> strategies;

    public PaymentService(List<PaymentStrategy> strategyList) {
        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        PaymentStrategy::supports,
                        Function.identity()
                ));
    }

    public boolean processPayment(Order order) {
        return strategies
                .get(order.getPaymentType())
                .pay(order.getValue());
    }
}
