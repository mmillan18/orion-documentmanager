package com.unibague.gradework.orionserver.controller;

import com.unibague.gradework.orionserver.model.TypeDocument;
import com.unibague.gradework.orionserver.service.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-documents")
public class TypeDocumentController {

    @Autowired
    private TypeDocumentService typeDocumentService;

    @PostMapping
    public ResponseEntity<TypeDocument> createTypeDocument(@RequestBody TypeDocument typeDocument) {
        return new ResponseEntity<>(typeDocumentService.createTypeDocument(typeDocument), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TypeDocument>> getAllTypeDocuments() {
        return new ResponseEntity<>(typeDocumentService.getAllTypeDocuments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDocument> getTypeDocumentById(@PathVariable String id) {
        return typeDocumentService.getTypeDocumentById(id)
                .map(type -> new ResponseEntity<>(type, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDocument> updateTypeDocument(@PathVariable String id, @RequestBody TypeDocument updatedTypeDocument) {
        TypeDocument updated = typeDocumentService.updateTypeDocument(id, updatedTypeDocument);
        return updated != null
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeDocument(@PathVariable String id) {
        typeDocumentService.deleteTypeDocument(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
