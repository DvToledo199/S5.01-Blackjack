package com.dvtoledo.blackjack.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotalValue() {
        int value = 0;
        for (Card card : cards) {
            value += card.rank().getValue();
        }
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }


}
