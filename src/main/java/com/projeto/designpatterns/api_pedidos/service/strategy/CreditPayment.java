package com.projeto.designpatterns.api_pedidos.service.strategy;

import com.projeto.designpatterns.api_pedidos.domain.enums.PaymentType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditPayment implements PaymentStrategy {

    @Override
    public boolean pay(BigDecimal amount) {
        return true;
    }

    @Override
    public PaymentType supports() {
        return PaymentType.CREDIT;
    }
}
