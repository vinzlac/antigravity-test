package com.example.ordertaking.application.port.in;

import com.example.ordertaking.domain.model.Order;
import java.math.BigDecimal;

public interface CreateOrderUseCase {
    Order createOrder(String product, Integer quantity, BigDecimal price);
}
