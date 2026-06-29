package com.dvtoledo.blackjack.domain.port;

import com.dvtoledo.blackjack.domain.model.PlayerStats;

import java.util.Optional;

public interface RankingRepository {

    void save(PlayerStats stats);

    Optional<PlayerStats> findByPlayerId(String playerId);
}
