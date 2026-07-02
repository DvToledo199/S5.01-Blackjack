package com.dvtoledo.blackjack.infrastructure.rest.controller;

import com.dvtoledo.blackjack.application.usecase.CreateGame;
import com.dvtoledo.blackjack.application.usecase.GetGame;
import com.dvtoledo.blackjack.application.usecase.HitCard;
import com.dvtoledo.blackjack.application.usecase.StandGame;
import com.dvtoledo.blackjack.domain.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final CreateGame createGame;
    private final HitCard hitCard;
    private final StandGame standGame;
    private final GetGame getGame;

    public GameController(CreateGame createGame, HitCard hitCard, StandGame standGame, GetGame getGame) {
        this.createGame = createGame;
        this.hitCard = hitCard;
        this.standGame = standGame;
        this.getGame = getGame;
    }


    @PostMapping
    public ResponseEntity<Game> createGame(@RequestParam String playerId) {
        Game game = createGame.execute(playerId);
        return ResponseEntity.ok(game);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGame(@PathVariable String id) {
        Game game = getGame.execute(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/{id}/hit")
    public ResponseEntity<Game> hitCard(@PathVariable String id) {
        Game game = hitCard.execute(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping("/{id}/stand")
    public ResponseEntity<Game> standGame(@PathVariable String id) {
        Game game = standGame.execute(id);
        return ResponseEntity.ok(game);
    }
}