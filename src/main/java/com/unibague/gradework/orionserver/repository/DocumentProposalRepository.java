package com.unibague.gradework.orionserver.repository;

import com.unibague.gradework.orionserver.model.DocumentProposal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentProposalRepository extends MongoRepository<DocumentProposal, String> {
}
