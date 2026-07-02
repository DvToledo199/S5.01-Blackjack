package com.dvtoledo.blackjack.infrastructure.rest.controller;

import com.dvtoledo.blackjack.application.usecase.GetRanking;
import com.dvtoledo.blackjack.domain.model.PlayerStats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    private final GetRanking getGame;

    public RankingController(GetRanking getRanking) {
        this.getGame = getRanking;
    }

    @GetMapping
    public ResponseEntity<List<PlayerStats>> getRanking() {
       List<PlayerStats> stats = getGame.execute();
       return ResponseEntity.ok(stats);
    }


}
