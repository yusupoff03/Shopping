package org.example.repository.product;


import org.example.model.product.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    int add(Product product,UUID userId);
    Boolean check(UUID owner_id,String model);
    List<Product> getUserProducts(UUID userId);
    int Delete(UUID productId);
    List<Product> getAll();
    int edit(Product product,UUID productId);
    Product getById(UUID productId);
    Integer getAmount(UUID id);
}
