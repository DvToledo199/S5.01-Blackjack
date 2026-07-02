package com.dvtoledo.blackjack.application.usecase;

import com.dvtoledo.blackjack.domain.model.PlayerStats;
import com.dvtoledo.blackjack.domain.port.RankingRepository;

import java.util.List;

public class GetRanking {

    private final RankingRepository rankingRepository;

    public GetRanking(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public List<PlayerStats> execute() {
        return rankingRepository.findAll();
    }
}
