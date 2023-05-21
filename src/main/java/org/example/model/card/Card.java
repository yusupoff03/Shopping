package org.example.model.card;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.model.BaseModel;
import org.example.model.user.User;

@Entity(name = "card")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Card extends BaseModel {
    @Column(unique = true, nullable = false)
    @NotBlank
    private String number;
    @Column(nullable = false)
    private String password;
    private CardType cardType;
    private Double balance;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User user;
}
