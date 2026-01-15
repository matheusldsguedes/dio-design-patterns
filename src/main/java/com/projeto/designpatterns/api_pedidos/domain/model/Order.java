package com.projeto.designpatterns.api_pedidos.domain.model;

import com.projeto.designpatterns.api_pedidos.domain.enums.OrderStatus;
import com.projeto.designpatterns.api_pedidos.domain.enums.PaymentType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private OrderStatus status;

    @Column(name = "created_at")
    private LocalDateTime creationSchedule;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public Order() {
    }

    public Order(BigDecimal value, PaymentType paymentType) {
        this.value = value;
        this.status = OrderStatus.PENDING;
        this.paymentType = paymentType;
        this.creationSchedule = LocalDateTime.now();
    }
    public void markAsPaid(){
        this.status = OrderStatus.PAID;
    }

    public void markAsCanceled(){
        this.status = OrderStatus.CANCELED;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public PaymentType getPaymentType() { return paymentType; }

    public LocalDateTime getCreationSchedule() {
        return creationSchedule;
    }
}
