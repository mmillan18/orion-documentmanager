package com.unibague.gradework.orionserver.repository;


import com.unibague.gradework.orionserver.model.Documents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentRepository extends MongoRepository<Documents, String> {
}
