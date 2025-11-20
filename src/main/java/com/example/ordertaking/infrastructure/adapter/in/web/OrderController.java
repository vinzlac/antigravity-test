package com.example.ordertaking.infrastructure.adapter.in.web;

import com.example.ordertaking.application.port.in.CreateOrderUseCase;
import com.example.ordertaking.domain.model.Order;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    public OrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = createOrderUseCase.createOrder(request.product(), request.quantity(), request.price());
        return ResponseEntity.ok(order);
    }

    public record CreateOrderRequest(String product, Integer quantity, BigDecimal price) {
    }
}
