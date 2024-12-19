package com.unibague.gradework.orionserver.repository;

import com.unibague.gradework.orionserver.model.TypeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TypeDocumentRepository extends MongoRepository<TypeDocument, String> {
    Optional<TypeDocument> findByName(String name);
}
