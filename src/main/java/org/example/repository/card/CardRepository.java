package org.example.repository.card;

import org.example.model.card.Card;
import org.example.model.user.User;

import java.util.List;
import java.util.UUID;

public interface CardRepository {
    int add(Card card);
    List<Card> getUserCards(UUID owner_id);
    void deleteById(UUID id);
    Card getById(UUID id);
    void edit(Card card);
    Card getByNumber(String number,String password,UUID userId);
    Card getBy(String number,UUID userId);
    void update(Card card);
}
