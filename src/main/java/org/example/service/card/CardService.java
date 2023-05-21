package org.example.service.card;

import org.example.dto.CardDto;
import org.example.model.card.Card;

import java.util.List;
import java.util.UUID;

public interface CardService {
int add(CardDto card, UUID userId);
List<Card> getUserCards(UUID userId);
void delete(UUID cardId);
Card getById(UUID id);
void edit(CardDto cardDto,UUID userId,UUID cardId);
Card getByNumber(String number,String password,UUID userId);
Card getBy(String number,UUID userId);
void update(Card card);
}
