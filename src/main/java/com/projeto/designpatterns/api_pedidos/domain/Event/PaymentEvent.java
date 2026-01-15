package com.projeto.designpatterns.api_pedidos.domain.Event;

public class PaymentEvent {

    private final Long orderId;

    public PaymentEvent(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}
