package com.dvtoledo.blackjack.infrastructure.persistence.mongodb;

import com.dvtoledo.blackjack.domain.model.Game;

public class GameMapper {

    static GameDocument toDocument(Game game) {
        return new GameDocument(
                game.getId(),
                game.getDeck(),
                game.getPlayerHand(),
                game.getDealerHand(),
                game.getStatus(),
                game.getPlayerId(),
                game.getResult()
        );
    }

    static Game toDomain(GameDocument doc) {
        return new Game(
                doc.getId(),
                doc.getDeck(),
                doc.getPlayerHand(),
                doc.getDealerHand(),
                doc.getStatus(),
                doc.getPlayerId()
        );
    }
}
