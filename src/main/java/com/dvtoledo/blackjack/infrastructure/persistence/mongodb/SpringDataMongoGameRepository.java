package com.dvtoledo.blackjack.infrastructure.persistence.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataMongoGameRepository extends MongoRepository<GameDocument, String> {


}