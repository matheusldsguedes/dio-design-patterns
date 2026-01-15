package com.projeto.designpatterns.api_pedidos.exception;

public class OrderException extends RuntimeException{
    public OrderException(String message) {
        super(message);
    }
}
