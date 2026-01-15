package com.projeto.designpatterns.api_pedidos.controller;

import com.projeto.designpatterns.api_pedidos.dto.OrderRequestDTO;
import com.projeto.designpatterns.api_pedidos.dto.OrderResponseDTO;
import com.projeto.designpatterns.api_pedidos.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@RequestBody OrderRequestDTO dto){
        return ResponseEntity.ok(service.createOrder(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }
}
