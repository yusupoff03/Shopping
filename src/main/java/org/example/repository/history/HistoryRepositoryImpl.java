package org.example.repository.history;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.history.History;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class HistoryRepositoryImpl implements HistoryRepository{
    @PersistenceContext
    private EntityManager entityManager;
    String findAll="select h from history h where h.sender_card.id=?1 or h.receiver_card.id=?2";

    @Override
    public int add(History history) {
        entityManager.persist(history);
        return 1;
    }

    @Override
    public List<History> getUserHistory(UUID cardId) {
       List<History>list= entityManager.createQuery(findAll, History.class).
                setParameter(1,cardId).
                setParameter(2,cardId).
                getResultList();
       if(list.isEmpty()){
           return null;
       }
       return list;
    }
}
