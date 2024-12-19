package com.unibague.gradework.orionserver.repository;

import com.unibague.gradework.orionserver.model.DocumentSustentation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentSustentationRepository extends MongoRepository<DocumentSustentation, String> {
}
