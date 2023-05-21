package org.example.model.product;

import jakarta.persistence.*;
import lombok.*;
import org.example.model.BaseModel;
import org.example.model.order.Order;
import org.example.model.user.User;

import java.util.List;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product extends BaseModel {
    private String type;
    private String manufacturer;
    private String model;
    private Double balance;
    private Integer amount;
    private ProductStatus isActive;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName ="id")
    private User user;
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<Order> orders;
}
