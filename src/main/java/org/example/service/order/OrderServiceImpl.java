package org.example.service.order;

import lombok.RequiredArgsConstructor;
import org.example.model.order.Order;
import org.example.repository.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    @Override
    public int add(Order order, UUID userId, UUID productId) {
       return orderRepository.add(order,productId,userId);
    }

    @Override
    public List<Order> getUserOrders(UUID userId) {
        return orderRepository.getUserOrders(userId);
    }

    @Override
    public int delete(UUID orderId) {
        return orderRepository.delete(orderId);
    }

    @Override
    public UUID getByOrderId(UUID orderId) {
        return orderRepository.getByOrderId(orderId);
    }

    @Override
    public Order getOrder(UUID orderId) {
        return orderRepository.getOrder(orderId);
    }

    @Override
    public void update(Order order) {
        orderRepository.update(order);
    }
}
