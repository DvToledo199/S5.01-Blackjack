package com.dvtoledo.blackjack.infrastructure.persistence.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMysqlRankingRepository extends JpaRepository<PlayerStatsEntity, String> {
}