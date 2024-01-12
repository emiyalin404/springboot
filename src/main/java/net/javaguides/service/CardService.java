package net.javaguides.service;

import net.javaguides.entity.Card;

public interface CardService {
    Card createCard(Card card) throws Exception;

    void deletecard(String cardNumber);
}
