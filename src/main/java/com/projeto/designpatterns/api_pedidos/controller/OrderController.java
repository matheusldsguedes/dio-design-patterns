package com.projeto.designpatterns.api_pedidos.controller;

import com.projeto.designpatterns.api_pedidos.dto.OrderRequestDTO;
import com.projeto.designpatterns.api_pedidos.dto.OrderResponseDTO;
import com.projeto.designpatterns.api_pedidos.facade.OrderFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderFacade facade;

    public OrderController(OrderFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDTO create(@RequestBody @Valid OrderRequestDTO dto){
        return facade.createOrder(dto);
    }
}
