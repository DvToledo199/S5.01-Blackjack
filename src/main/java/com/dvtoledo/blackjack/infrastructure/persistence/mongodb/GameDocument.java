package com.dvtoledo.blackjack.infrastructure.persistence.mongodb;

import com.dvtoledo.blackjack.domain.model.Deck;
import com.dvtoledo.blackjack.domain.model.GameResult;
import com.dvtoledo.blackjack.domain.model.GameStatus;
import com.dvtoledo.blackjack.domain.model.Hand;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public class GameDocument {

    @Id
    private String id;
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private GameStatus status;
    private String playerId;
    private GameResult result;

    public GameDocument() {
    }

    public GameDocument(String id, Deck deck, Hand playerHand, Hand dealerHand, GameStatus status, String playerId, GameResult result) {
        this.id = id;
        this.deck = deck;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
        this.status = status;
        this.playerId = playerId;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getPlayerId() {
        return playerId;
    }

    public GameResult getResult() {
        return result;
    }
}