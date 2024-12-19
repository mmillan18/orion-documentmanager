package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.TypeDocument;
import com.unibague.gradework.orionserver.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeDocumentServiceImpl implements TypeDocumentService {

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    @Override
    public TypeDocument createTypeDocument(TypeDocument typeDocument) {
        return typeDocumentRepository.save(typeDocument);
    }

    @Override
    public List<TypeDocument> getAllTypeDocuments() {
        return typeDocumentRepository.findAll();
    }

    @Override
    public Optional<TypeDocument> getTypeDocumentById(String id) {
        return typeDocumentRepository.findById(id);
    }

    @Override
    public TypeDocument updateTypeDocument(String id, TypeDocument updatedTypeDocument) {
        return typeDocumentRepository.findById(id).map(existingTypeDocument -> {
            existingTypeDocument.setName(updatedTypeDocument.getName());
            return typeDocumentRepository.save(existingTypeDocument);
        }).orElse(null);
    }

    @Override
    public void deleteTypeDocument(String id) {
        typeDocumentRepository.deleteById(id);
    }
}
