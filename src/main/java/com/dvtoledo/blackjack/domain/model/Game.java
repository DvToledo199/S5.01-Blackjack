package com.dvtoledo.blackjack.domain.model;

public class Game {

    private String id;
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private GameStatus status;
    private String playerId;
    private GameResult result;

    public Game(String id, Deck deck, Hand playerHand, Hand dealerHand, GameStatus status, String playerId) {
        this.id = id;
        this.deck = deck;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
        this.status = status;
        this.playerId = playerId;
    }

    public void startGame() {
        deck.shuffle();
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        this.status = GameStatus.IN_PROGRESS;
    }

    public void playerHit() {
        playerHand.addCard(deck.dealCard());
        if (playerHand.getTotalValue() > 21) {
            this.status = GameStatus.PLAYER_BUST;
        }
    }

    public void playerStand() {
        while (dealerHand.getTotalValue() < 17) {
            dealerHand.addCard(deck.dealCard());
        }
        if (dealerHand.getTotalValue() > 21 || dealerHand.getTotalValue() < playerHand.getTotalValue()) {
            result = GameResult.PLAYER;
        } else if (dealerHand.getTotalValue() > playerHand.getTotalValue()) {
            result = GameResult.DEALER;
        } else {
            result = GameResult.DRAW;
        }
        this.status = GameStatus.FINISHED;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public String getId() {
        return id;
    }

    public GameStatus getStatus() {
        return status;
    }

    public GameResult getResult() {
        return result;
    }

    public String getPlayerId() {
        return playerId;
    }
}
