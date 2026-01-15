package com.projeto.designpatterns.api_pedidos.service;

import com.projeto.designpatterns.api_pedidos.domain.Event.PaymentEvent;
import com.projeto.designpatterns.api_pedidos.domain.model.Order;
import com.projeto.designpatterns.api_pedidos.dto.OrderRequestDTO;
import com.projeto.designpatterns.api_pedidos.dto.OrderResponseDTO;
import com.projeto.designpatterns.api_pedidos.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import com.projeto.designpatterns.api_pedidos.exception.OrderException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final ApplicationEventPublisher publisher;

    public OrderService(OrderRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }
    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {
        Order order = new Order(dto.value(), dto.paymentType());
        repository.save(order);

        publisher.publishEvent(new PaymentEvent(order.getId()));

        return OrderResponseDTO.from(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(OrderResponseDTO::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public OrderResponseDTO findById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        return OrderResponseDTO.from(order);
    }

    @Transactional
    public void updateStatus(Long orderId, boolean paid) {
        Order order = repository.findById(orderId)
                .orElseThrow();

        if (paid) order.markAsPaid();
        else order.markAsCanceled();
    }
}
