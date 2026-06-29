package com.dvtoledo.blackjack.domain.model;

public class PlayerStats {

    private String playerId;
    private int wins;
    private int losses;
    private int draws;
    private int totalScore;

    public PlayerStats(String playerId) {
        this.playerId = playerId;
    }

    public void addWin() {
        this.wins++;
        totalScore++;
    }

    public void addLoss() {
        this.losses++;
        totalScore--;
    }

    public void addDraw() {
        this.draws++;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
