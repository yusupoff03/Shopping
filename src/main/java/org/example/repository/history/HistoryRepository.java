package org.example.repository.history;

import org.example.model.history.History;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository {
    int add(History history);
    List<History> getUserHistory(UUID cardId);
}
