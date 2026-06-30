package com.dvtoledo.blackjack.infrastructure.persistence.mysql;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_stats")
public class PlayerStatsEntity {

    @Id
    private String playerId;
    private int wins;
    private int losses;
    private int draws;
    private int totalScore;

    public PlayerStatsEntity() {
    }

    public PlayerStatsEntity(String playerId, int wins, int losses, int draws, int totalScore) {
        this.playerId = playerId;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.totalScore = totalScore;
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
