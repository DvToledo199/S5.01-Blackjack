package com.dvtoledo.blackjack.infrastructure.persistence.mongodb;

import com.dvtoledo.blackjack.domain.model.Game;
import com.dvtoledo.blackjack.domain.port.GameRepository;

import java.util.Optional;

public class MongoGameRepository implements GameRepository {

    private final SpringDataMongoGameRepository springDataMongoGameRepository;
    public MongoGameRepository(SpringDataMongoGameRepository springDataMongoGameRepository) {
        this.springDataMongoGameRepository = springDataMongoGameRepository;
    }

    @Override
    public void save(Game game) {
        GameDocument doc = GameMapper.toDocument(game);
        springDataMongoGameRepository.save(doc);

    }

    @Override
    public Optional<Game> findById(String id) {
        return springDataMongoGameRepository.findById(id)
                .map(GameMapper::toDomain);
    }
}
