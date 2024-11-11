package com.unibague.gradework.orionserver.repository;

import com.unibague.gradework.orionserver.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {
}
