package org.example.service.order;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import org.example.model.order.Order;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    int add(Order order, UUID userId,UUID productId);
    List<Order> getUserOrders(UUID userId);
    int delete(UUID orderId);
    UUID getByOrderId(UUID orderId);
    Order getOrder(UUID orderId);
    void update(Order order);
}
