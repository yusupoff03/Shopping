package org.example.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.model.BaseModel;
import org.example.model.card.Card;
import org.example.model.order.Order;
import org.example.model.product.Product;

import java.util.List;


@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseModel {
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String phoneNumber;
    @Column(nullable = false)
    private String password;
    private UserRole role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Product> products;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Card> cards;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Order> orders;
}
