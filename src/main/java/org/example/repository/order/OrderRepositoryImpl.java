package org.example.repository.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.model.order.Order;
import org.example.model.order.OrderStatus;
import org.example.model.product.Product;
import org.example.model.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;
    String getUserOrder = "select o from orders o where o.user.id=?1 and o.status=?2";
    String DELETE = "delete from orders o where o.id=?1";
    String GET_BY_ORDER_ID = "select o.product.id from orders o where o.id=?1";
    String UPDATE = "update orders o set o.amount=?1,o.balance=?3 where o.id=?2";

    @Override
    public int add(Order order, UUID productId, UUID userId) {
        User user = new User();
        user.setId(userId);
        Product product = new Product();
        product.setId(productId);
        order.setUser(user);
        order.setProduct(product);
        entityManager.persist(order);
        return 1;
    }

    @Override
    public List<Order> getUserOrders(UUID userId) {
        try {
            return entityManager.createQuery(getUserOrder, Order.class).
                    setParameter(1, userId).
                    setParameter(2, OrderStatus.CREATED).
                    getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public int delete(UUID orderId) {
        entityManager.createQuery(DELETE).
                setParameter(1, orderId).
                executeUpdate();
        return 1;
    }

    @Override
    public UUID getByOrderId(UUID orderId) {
        return entityManager.
                createQuery(GET_BY_ORDER_ID, UUID.class).
                setParameter(1, orderId).
                getSingleResult();
    }

    @Override
    public Order getOrder(UUID orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }
}
