package org.example.repository.card;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.example.model.card.Card;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class CardRepositoryImpl implements CardRepository {
    @PersistenceContext
    private EntityManager entityManager;
    String getUserCards = "select c from card c where user.id=?1";
    String DELETE_BY_ID = "delete  from card  where id=?1";
    String CHECK = "select c from card c where number=?1";
    String getByNumber="select c from card c where c.number=?1 and c.password=?2 and c.user.id=?3";
    String getBy="select c from card c where c.number=?1 and c.user.id=?2";


    @Override
    public int add(Card card) {
        entityManager.persist(card);
        return 1;
    }

    @Override
    public List<Card> getUserCards(UUID owner_id) {
        List<Card> list = entityManager.createQuery(getUserCards, Card.class).setParameter(1, owner_id).getResultList();
        if(list.isEmpty()){
            return null;
        }
        return list;
    }

    @Override
    public void deleteById(UUID id) {
        System.out.println(1);
        entityManager.createQuery(DELETE_BY_ID).setParameter(1, id).executeUpdate();
    }

    @Override
    public Card getById(UUID id) {
        return entityManager.find(Card.class, id);
    }

    @Override
    public void edit(Card card) {
        entityManager.merge(card);
    }

    @Override
    public Card getByNumber(String number, String password, UUID userId) {
        try {
           return entityManager.createQuery(getByNumber, Card.class).
                    setParameter(1,number).
                    setParameter(2,password).
                    setParameter(3,userId).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Card getBy(String number, UUID userId) {
        try {
          return entityManager.createQuery(getBy, Card.class).
                    setParameter(1,number).
                    setParameter(2,userId).
                    getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void update(Card card) {
        entityManager.merge(card);
    }

    public Boolean check(String number) {
        try {
            Card card = entityManager.createQuery(CHECK, Card.class).setParameter(1, number).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }

    }
}
