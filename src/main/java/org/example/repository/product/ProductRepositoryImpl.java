package org.example.repository.product;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.model.product.Product;
import org.example.model.product.ProductStatus;
import org.example.model.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    String getByUserId = "select p from product p where p.user.id=?1 AND  p.model=?2";
    String deleteById = "delete from product where id=?1";
    String edit = "update product set type=?1,manufacturer=?2,model=?3,balance=?4,amount=?5 where id=?6";
    String getUserProducts = "select p from product p where p.user.id=?1";
    String getAll = "select p from product p where p.isActive=?1";
    String getAmount = "select p.amount from product p where id=?1";

    @Override
    @Transactional
    public int add(Product product, UUID userId) {
        if (check(userId, product.getModel())) {
            return 0;
        }
        User user = new User();
        user.setId(userId);
        product.setUser(user);
        entityManager.persist(product);
        return 1;
    }

    @Override
    public Boolean check(UUID owner_id, String model) {
        try {
            Product product = entityManager.createQuery(getByUserId, Product.class).
                    setParameter(1, owner_id).
                    setParameter(2, model).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }

    }

    @Override
    public List<Product> getUserProducts(UUID userId) {
        List<Product> list = entityManager.createQuery(getUserProducts, Product.class).setParameter(1, userId).getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    @Transactional
    public int Delete(UUID productId) {
        System.out.println(productId);
        entityManager.createQuery(deleteById).setParameter(1, productId).executeUpdate();
        return 1;
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery(getAll, Product.class).setParameter(1, ProductStatus.ACTIVE).getResultList();
    }

    @Override
    @Transactional
    public int edit(Product product, UUID productId) {
        entityManager.createQuery(edit).
                setParameter(1, product.getType()).
                setParameter(2, product.getManufacturer()).
                setParameter(3, product.getModel()).
                setParameter(4, product.getBalance()).
                setParameter(5, product.getAmount()).
                setParameter(6, productId).executeUpdate();
        return 1;
    }

    @Override
    public Product getById(UUID productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public Integer getAmount(UUID id) {
        return entityManager.
                createQuery(getAmount, Integer.class).
                setParameter(1, id)
                .getSingleResult();
    }
}
