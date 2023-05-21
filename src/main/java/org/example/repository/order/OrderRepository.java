package org.example.repository.order;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.model.order.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    int add(Order order, UUID productId, UUID userId);

    List<Order> getUserOrders(UUID userId);
    int delete(UUID orderId);
    UUID getByOrderId(UUID orderId);
    Order getOrder(UUID orderId);
    void update(Order order);
}
