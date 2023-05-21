package org.example.service.card;

import lombok.RequiredArgsConstructor;
import org.example.dto.CardDto;
import org.example.model.card.Card;
import org.example.model.user.User;
import org.example.repository.card.CardRepository;
import org.example.service.user.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
private final CardRepository cardRepository;
private final UserService userService;
    @Override
    public int add(CardDto cardDto, UUID userId) {
        User user=userService.getById(userId);
        Card card=new Card();
        card.setBalance(cardDto.getBalance());
        card.setPassword(cardDto.getPassword());
        card.setNumber(cardDto.getNumber());
        card.setCardType(cardDto.getType());
        card.setUser(user);
        return cardRepository.add(card);
    }

    @Override
    public List<Card> getUserCards(UUID userId) {
        return cardRepository.getUserCards(userId);
    }

    @Override
    public void delete(UUID cardId) {
        cardRepository.deleteById(cardId);
    }

    @Override
    public Card getById(UUID id) {
        return cardRepository.getById(id);
    }

    @Override
    public void edit(CardDto cardDto, UUID userId, UUID cardId) {
        Card card=new Card();
        card.setCardType(cardDto.getType());
        card.setNumber(cardDto.getNumber());
        card.setPassword(cardDto.getPassword());
        card.setBalance(cardDto.getBalance());
        card.setId(cardId);
        User user=userService.getById(userId);
        card.setUser(user);
        cardRepository.edit(card);
    }

    @Override
    public Card getByNumber(String number, String password, UUID userId) {
        return cardRepository.getByNumber(number,password,userId);
    }

    @Override
    public Card getBy(String number, UUID userId) {
        return cardRepository.getBy(number,userId);
    }

    @Override
    public void update(Card card) {
        cardRepository.update(card);
    }
}
