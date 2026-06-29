package com.dvtoledo.blackjack.application.usecase;

import com.dvtoledo.blackjack.domain.model.Deck;
import com.dvtoledo.blackjack.domain.model.Game;
import com.dvtoledo.blackjack.domain.model.GameStatus;
import com.dvtoledo.blackjack.domain.model.Hand;
import com.dvtoledo.blackjack.domain.port.GameRepository;

import java.util.UUID;

public class CreateGame {

    private final GameRepository gameRepository;

    public CreateGame(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game execute(String playerId) {
        Game game = new Game(
                UUID.randomUUID().toString(),
                new Deck(),
                new Hand(),
                new Hand(),
                GameStatus.IN_PROGRESS,
                playerId
        );
        game.startGame();
        gameRepository.save(game);
        return game;
    }
}
