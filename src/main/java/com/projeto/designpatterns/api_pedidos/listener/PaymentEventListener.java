package com.projeto.designpatterns.api_pedidos.listener;

import com.projeto.designpatterns.api_pedidos.domain.Event.PaymentEvent;
import com.projeto.designpatterns.api_pedidos.domain.model.Order;
import com.projeto.designpatterns.api_pedidos.repository.OrderRepository;
import com.projeto.designpatterns.api_pedidos.service.OrderService;
import com.projeto.designpatterns.api_pedidos.service.PaymentService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventListener {
    private final OrderRepository repository;
    private final PaymentService paymentService;
    private final OrderService orderService;

    public PaymentEventListener(OrderRepository repository,
                                PaymentService paymentService,
                                OrderService orderService) {
        this.repository = repository;
        this.paymentService = paymentService;
        this.orderService = orderService;
    }

    @EventListener
    public void handlePayment(PaymentEvent event) {
        Order order = repository.findById(event.getOrderId())
                .orElseThrow();

        boolean paid = paymentService.processPayment(order);
        orderService.updateStatus(order.getId(), paid);
    }
}
