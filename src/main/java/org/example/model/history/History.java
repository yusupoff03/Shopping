package org.example.model.history;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.model.BaseModel;
import org.example.model.card.Card;


@Entity(name = "history")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class History extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "sender_card_id",referencedColumnName = "id")
    private Card sender_card;
    @ManyToOne
    @JoinColumn(name = "receiver_card_id",referencedColumnName = "id")
    private Card receiver_card;
    private Double amount;
}
