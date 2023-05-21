package org.example.repository.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.example.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    String check = "select u from users u where u.phoneNumber=?1";
    String sign_in="select u from users u where u.phoneNumber=?1 and u.password=?2";

    @Override
    @Transactional
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Boolean checkPhoneNumber(String phoneNumber) {
        try {
            User result = entityManager.createQuery(check, User.class).setParameter(1, phoneNumber).getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }

    }

    public User sign_in(String phoneNumber, String password) {
        try {
           return entityManager.createQuery(sign_in, User.class).
                    setParameter(1, phoneNumber).
                    setParameter(2, password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public User getById(UUID id) {
        return entityManager.find(User.class, id);
    }
}
