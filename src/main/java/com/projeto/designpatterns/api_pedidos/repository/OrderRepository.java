package com.projeto.designpatterns.api_pedidos.repository;

import com.projeto.designpatterns.api_pedidos.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
