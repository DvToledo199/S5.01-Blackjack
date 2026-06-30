package com.dvtoledo.blackjack.infrastructure.persistence.mysql;

import com.dvtoledo.blackjack.domain.model.PlayerStats;

public class PlayerStatsMapper {

    static PlayerStatsEntity toEntity(PlayerStats stats) {
        return new PlayerStatsEntity(
                stats.getPlayerId(),
                stats.getWins(),
                stats.getLosses(),
                stats.getDraws(),
                stats.getTotalScore()
        );
    }

    static PlayerStats toDomain(PlayerStatsEntity entity) {
        return new PlayerStats(
                entity.getPlayerId(),
                entity.getWins(),
                entity.getLosses(),
                entity.getDraws(),
                entity.getTotalScore()
        );
    }
}
