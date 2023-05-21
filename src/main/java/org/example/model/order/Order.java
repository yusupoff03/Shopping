package org.example.model.order;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.model.BaseModel;
import org.example.model.product.Product;
import org.example.model.user.User;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order extends BaseModel {
    private Integer amount;
    private OrderStatus status;
    private Double balance;
    @ManyToOne
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;
}
