package com.example.ordertaking.application.service;

import com.example.ordertaking.application.port.in.CreateOrderUseCase;
import com.example.ordertaking.application.port.out.OrderRepositoryPort;
import com.example.ordertaking.domain.model.Order;
import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements CreateOrderUseCase {

    private final OrderRepositoryPort orderRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order createOrder(String product, Integer quantity, BigDecimal price) {
        Order order = new Order(UUID.randomUUID(), product, quantity, price);
        return orderRepositoryPort.save(order);
    }
}
