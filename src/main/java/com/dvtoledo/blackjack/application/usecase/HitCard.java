package com.dvtoledo.blackjack.application.usecase;

import com.dvtoledo.blackjack.domain.model.Game;
import com.dvtoledo.blackjack.domain.port.GameRepository;

public class HitCard {

    private final GameRepository gameRepository;

    public HitCard(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game execute(String id) {
        Game game = gameRepository.findById(id).orElse(null);
        if (game == null) {
            throw new RuntimeException("Game not found: " + id);
        }
        game.playerHit();
        gameRepository.save(game);
        return game;
    }
}
