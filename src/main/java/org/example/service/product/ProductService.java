package org.example.service.product;

import org.example.model.product.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    int add(Product product, UUID userId);
    List<Product> getUserProducts(UUID userId);
    int delete(UUID productId);
    List<Product> getALL();
    int edit(Product product,UUID productId);
    Product getBYId(UUID productId);
    Integer getAmount(UUID id);
}
