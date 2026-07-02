package com.dvtoledo.blackjack.infrastructure.persistence.mysql;

import com.dvtoledo.blackjack.domain.model.PlayerStats;
import com.dvtoledo.blackjack.domain.port.RankingRepository;

import java.util.List;
import java.util.Optional;

public class MysqlRankingRepository implements RankingRepository {

    private final SpringDataMysqlRankingRepository springDataMysqlRankingRepository;
    public MysqlRankingRepository(SpringDataMysqlRankingRepository springDataMysqlRankingRepository) {
        this.springDataMysqlRankingRepository = springDataMysqlRankingRepository;
    }

    @Override
    public void save(PlayerStats stats) {
        springDataMysqlRankingRepository.save(PlayerStatsMapper.toEntity(stats));

    }

    @Override
    public Optional<PlayerStats> findByPlayerId(String playerId) {
        return springDataMysqlRankingRepository.findById(playerId)
                .map(PlayerStatsMapper::toDomain);
    }

    @Override
    public List<PlayerStats> findAll() {
       return springDataMysqlRankingRepository.findAll()
                .stream().map(PlayerStatsMapper::toDomain).toList();
    }
}
