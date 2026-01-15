package com.projeto.designpatterns.api_pedidos.dto;

import com.projeto.designpatterns.api_pedidos.domain.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderRequestDTO (@NotNull @Positive BigDecimal value, PaymentType paymentType){
}
