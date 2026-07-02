package com.dvtoledo.blackjack.application.usecase;

import com.dvtoledo.blackjack.domain.model.Game;
import com.dvtoledo.blackjack.domain.model.GameResult;
import com.dvtoledo.blackjack.domain.model.PlayerStats;
import com.dvtoledo.blackjack.domain.port.GameRepository;
import com.dvtoledo.blackjack.domain.port.RankingRepository;

public class StandGame {

    private final GameRepository gameRepository;
    private final RankingRepository rankingRepository;

    public StandGame(GameRepository gameRepository, RankingRepository rankingRepository) {
        this.gameRepository = gameRepository;
        this.rankingRepository = rankingRepository;
    }

    public Game execute(String id) {
        Game game = gameRepository.findById(id).orElseThrow(()->new RuntimeException("Game not found: " + id));


        game.playerStand();
        gameRepository.save(game);
        PlayerStats stats = rankingRepository.findByPlayerId(game.getPlayerId())
                .orElse(new PlayerStats(game.getPlayerId()));

        if (game.getResult() == GameResult.PLAYER) {
            stats.addWin();
        } else if (game.getResult() == GameResult.DEALER) {
            stats.addLoss();
        } else {
            stats.addDraw();
        }
        rankingRepository.save(stats);

        return game;

    }
}
