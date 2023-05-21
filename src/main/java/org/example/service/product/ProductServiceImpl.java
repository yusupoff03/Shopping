package org.example.service.product;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.example.model.product.Product;
import org.example.repository.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public int add(Product product, UUID userId) {
       return productRepository.add(product,userId);
    }

    @Override
    public List<Product> getUserProducts(UUID userId) {
        return productRepository.getUserProducts(userId);
    }

    @Override
    public int delete(UUID productId) {
       return productRepository.Delete(productId);
    }

    @Override
    public List<Product> getALL() {
        return productRepository.getAll();
    }

    @Override
    public int edit(Product product, UUID productId) {
        return productRepository.edit(product,productId);
    }

    @Override
    public Product getBYId(UUID productId) {
        return productRepository.getById(productId);
    }

    @Override
    public Integer getAmount(UUID id) {
        return productRepository.getAmount(id);
    }
}
