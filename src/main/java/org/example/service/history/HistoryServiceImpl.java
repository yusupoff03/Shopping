package org.example.service.history;

import lombok.RequiredArgsConstructor;
import org.example.model.card.Card;
import org.example.model.history.History;
import org.example.repository.history.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService{
    private final HistoryRepository historyRepository;
    @Override
    public int add(Card card,Card card1,Double amount) {
        History history=new History();
        history.setSender_card(card);
        history.setReceiver_card(card1);
        history.setAmount(amount);
        return historyRepository.add(history);
    }

    @Override
    public List<History> getCardHistory(UUID cardId) {
        return historyRepository.getUserHistory(cardId);
    }
}
