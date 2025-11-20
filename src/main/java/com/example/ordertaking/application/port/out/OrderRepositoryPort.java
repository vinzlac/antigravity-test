package com.example.ordertaking.application.port.out;

import com.example.ordertaking.domain.model.Order;

public interface OrderRepositoryPort {
    Order save(Order order);
}
