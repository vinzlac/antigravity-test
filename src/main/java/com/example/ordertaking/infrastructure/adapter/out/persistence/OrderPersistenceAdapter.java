package com.example.ordertaking.infrastructure.adapter.out.persistence;

import com.example.ordertaking.application.port.out.OrderRepositoryPort;
import com.example.ordertaking.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderPersistenceAdapter implements OrderRepositoryPort {

    private final JpaOrderRepository jpaOrderRepository;

    public OrderPersistenceAdapter(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = new OrderEntity(order.id(), order.product(), order.quantity(), order.price());
        OrderEntity savedEntity = jpaOrderRepository.save(entity);
        return new Order(savedEntity.getId(), savedEntity.getProduct(), savedEntity.getQuantity(),
                savedEntity.getPrice());
    }
}
