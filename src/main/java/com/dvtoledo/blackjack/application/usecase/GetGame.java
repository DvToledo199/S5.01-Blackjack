package com.dvtoledo.blackjack.application.usecase;

import com.dvtoledo.blackjack.domain.model.Game;
import com.dvtoledo.blackjack.domain.port.GameRepository;

public class GetGame {

    private final GameRepository gameRepository;

    public GetGame(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game execute(String id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found: " + id));
        return game;
    }
}
