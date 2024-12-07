package com.unibague.gradework.orionserver.repository;

import com.unibague.gradework.orionserver.model.Actors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends MongoRepository<Actors, Long> {
}
