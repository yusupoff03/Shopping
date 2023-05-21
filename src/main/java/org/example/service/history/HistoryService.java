package org.example.service.history;

import org.example.model.card.Card;
import org.example.model.history.History;

import java.util.List;
import java.util.UUID;

public interface HistoryService {
    int add(Card card,Card card1,Double amount);
    List<History> getCardHistory(UUID cardId);
}
