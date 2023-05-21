package org.example.dto;

import lombok.*;
import org.example.model.card.CardType;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CardDto {
private String number;
private String password;
private CardType type;
private Double balance;
}
