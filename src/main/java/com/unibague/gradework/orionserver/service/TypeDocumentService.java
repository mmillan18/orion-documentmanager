package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.TypeDocument;

import java.util.List;
import java.util.Optional;

public interface TypeDocumentService {
    TypeDocument createTypeDocument(TypeDocument typeDocument);
    List<TypeDocument> getAllTypeDocuments();
    Optional<TypeDocument> getTypeDocumentById(String id);

    TypeDocument updateTypeDocument(String id, TypeDocument updatedTypeDocument);
    void deleteTypeDocument(String id);
}
