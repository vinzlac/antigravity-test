package com.example.ordertaking.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Order(UUID id, String product, Integer quantity, BigDecimal price) {
    public Order {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
    }
}
