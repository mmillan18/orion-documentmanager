package com.unibague.gradework.orionserver.repository;

import com.unibague.gradework.orionserver.model.DocumentReport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DocumentReportRepository extends MongoRepository<DocumentReport, String> {
}
