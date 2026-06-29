package com.dvtoledo.blackjack.domain.port;

import com.dvtoledo.blackjack.domain.model.Game;

import java.util.Optional;

public interface GameRepository {

    void save(Game game);

    Optional<Game> findById(String id);

}
