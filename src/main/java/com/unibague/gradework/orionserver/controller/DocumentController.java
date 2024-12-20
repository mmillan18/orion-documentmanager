package com.unibague.gradework.orionserver.controller;

import com.unibague.gradework.orionserver.model.DocumentProposal;
import com.unibague.gradework.orionserver.model.DocumentReport;
import com.unibague.gradework.orionserver.model.DocumentSustentation;
import com.unibague.gradework.orionserver.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing documents.
 * This controller provides endpoints for creating, retrieving, updating, and deleting
 * different types of documents:
 * - DocumentProposal
 * - DocumentReport
 * - DocumentSustentation
 */
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * Creates a new DocumentProposal.
     *
     * @param proposal The DocumentProposal object to create.
     * @return ResponseEntity containing the created DocumentProposal and HTTP status 201 (Created).
     */
    @PostMapping("/proposal")
    public ResponseEntity<DocumentProposal> createProposal(@RequestBody DocumentProposal proposal,
                                                           @RequestParam String typeName) {
        return new ResponseEntity<>(documentService.createProposal(proposal, typeName), HttpStatus.CREATED);
    }

    /**
     * Retrieves all DocumentProposal records.
     *
     * @return ResponseEntity containing the list of DocumentProposals and HTTP status 200 (OK).
     */
    @GetMapping("/proposal")
    public ResponseEntity<List<DocumentProposal>> getAllProposals() {
        return new ResponseEntity<>(documentService.getAllProposals(), HttpStatus.OK);
    }

    /**
     * Updates an existing DocumentProposal by ID.
     *
     * @param id       The ID of the DocumentProposal to update.
     * @param updatedProposal The updated DocumentProposal object.
     * @return ResponseEntity containing the updated DocumentProposal and HTTP status 200 (OK),
     * or HTTP status 404 (Not Found) if the proposal does not exist.
     */
    @PutMapping("/proposal/{id}")
    public ResponseEntity<DocumentProposal> updateProposal(
            @PathVariable String id, @RequestBody DocumentProposal updatedProposal) {
        DocumentProposal updated = documentService.updateProposal(id, updatedProposal);
        return updated != null
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Deletes a DocumentProposal by ID.
     *
     * @param id The ID of the DocumentProposal to delete.
     * @return ResponseEntity with HTTP status 204 (No Content).
     */
    @DeleteMapping("/proposal/{id}")
    public ResponseEntity<Void> deleteProposal(@PathVariable String id) {
        documentService.deleteProposal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Creates a new DocumentReport.
     *
     * @param report The DocumentReport object to create.
     * @return ResponseEntity containing the created DocumentReport and HTTP status 201 (Created).
     */
    @PostMapping("/report")
    public ResponseEntity<DocumentReport> createReport(@RequestBody DocumentReport report,
                                                       @RequestParam String typeName) {
        return new ResponseEntity<>(documentService.createReport(report, typeName), HttpStatus.CREATED);
    }

    /**
     * Retrieves all DocumentReport records.
     *
     * @return ResponseEntity containing the list of DocumentReports and HTTP status 200 (OK).
     */
    @GetMapping("/report")
    public ResponseEntity<List<DocumentReport>> getAllReports() {
        return new ResponseEntity<>(documentService.getAllReports(), HttpStatus.OK);
    }

    /**
     * Updates an existing DocumentReport by ID.
     *
     * @param id     The ID of the DocumentReport to update.
     * @param updatedReport The updated DocumentReport object.
     * @return ResponseEntity containing the updated DocumentReport and HTTP status 200 (OK),
     * or HTTP status 404 (Not Found) if the report does not exist.
     */
    @PutMapping("/report/{id}")
    public ResponseEntity<DocumentReport> updateReport(
            @PathVariable String id, @RequestBody DocumentReport updatedReport) {
        DocumentReport updated = documentService.updateReport(id, updatedReport);
        return updated != null
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /**
     * Deletes a DocumentReport by ID.
     *
     * @param id The ID of the DocumentReport to delete.
     * @return ResponseEntity with HTTP status 204 (No Content).
     */
    @DeleteMapping("/report/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable String id) {
        documentService.deleteReport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Creates a new DocumentSustentation.
     *
     * @param sustentation The DocumentSustentation object to create.
     * @return ResponseEntity containing the created DocumentSustentation and HTTP status 201 (Created).
     */
    @PostMapping("/sustentation")
    public ResponseEntity<DocumentSustentation> createSustentation(@RequestBody DocumentSustentation sustentation,
                                                                   @RequestParam String typeName) {
        return new ResponseEntity<>(documentService.createSustentation(sustentation, typeName), HttpStatus.CREATED);
    }

    /**
     * Retrieves all DocumentSustentation records.
     *
     * @return ResponseEntity containing the list of DocumentSustentations and HTTP status 200 (OK).
     */
    @GetMapping("/sustentation")
    public ResponseEntity<List<DocumentSustentation>> getAllSustentations() {
        return new ResponseEntity<>(documentService.getAllSustentations(), HttpStatus.OK);
    }

    /**
     * Updates an existing DocumentSustentation by ID.
     *
     * @param id            The ID of the DocumentSustentation to update.
     * @param updatedSustentation  The updated DocumentSustentation object.
     * @return ResponseEntity containing the updated DocumentSustentation and HTTP status 200 (OK),
     * or HTTP status 404 (Not Found) if the sustentation does not exist.
     */
    @PutMapping("/sustentation/{id}")
    public ResponseEntity<DocumentSustentation> updateSustentation(
            @PathVariable String id, @RequestBody DocumentSustentation updatedSustentation) {
        DocumentSustentation updated = documentService.updateSustentation(id, updatedSustentation);
        return updated != null
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Deletes a DocumentSustentation by ID.
     *
     * @param id The ID of the DocumentSustentation to delete.
     * @return ResponseEntity with HTTP status 204 (No Content).
     */
    @DeleteMapping("/sustentation/{id}")
    public ResponseEntity<Void> deleteSustentation(@PathVariable  String id) {
        documentService.deleteSustentation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
