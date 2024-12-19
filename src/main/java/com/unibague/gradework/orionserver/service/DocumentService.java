package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.*;

import java.util.List;
import java.util.Optional;

/**
 * Service interface to manage Documents, including proposals, reports, and sustentations.
 */
public interface DocumentService {

    /**
     * Creates a new DocumentProposal.
     * @param proposal The DocumentProposal object to be created.
     * @return The saved DocumentProposal.
     */
    DocumentProposal createProposal(DocumentProposal proposal, String typeName);

    /**
     * Creates a new DocumentReport.
     * @param report The DocumentReport object to be created.
     * @return The saved DocumentReport.
     */
    DocumentReport createReport(DocumentReport report, String typeName);

    /**
     * Creates a new DocumentSustentation.
     * @param sustentation The DocumentSustentation object to be created.
     * @return The saved DocumentSustentation.
     */
    DocumentSustentation createSustentation(DocumentSustentation sustentation, String typeName);

    /**
     * Retrieves all documents, including proposals, reports, and sustentations.
     * @return A list of all documents.
     */
    List<Documents> getAllDocuments();

    /**
     * Retrieves all DocumentProposal records.
     * @return A list of DocumentProposal objects.
     */
    List<DocumentProposal> getAllProposals();

    /**
     * Retrieves all DocumentReport records.
     * @return A list of DocumentReport objects.
     */
    List<DocumentReport> getAllReports();

    /**
     * Retrieves all DocumentSustentation records.
     * @return A list of DocumentSustentation objects.
     */
    List<DocumentSustentation> getAllSustentations();

    /**
     * Updates an existing DocumentProposal.
     * @param id The ID of the DocumentProposal to update.
     * @param updatedProposal The updated DocumentProposal object.
     * @return The updated DocumentProposal, if found.
     */
    DocumentProposal updateProposal(String id, DocumentProposal updatedProposal);

    /**
     * Updates an existing DocumentReport.
     * @param id The ID of the DocumentReport to update.
     * @param updatedReport The updated DocumentReport object.
     * @return The updated DocumentReport, if found.
     */
    DocumentReport updateReport(String id, DocumentReport updatedReport);

    /**
     * Updates an existing DocumentSustentation.
     * @param id The ID of the DocumentSustentation to update.
     * @param updatedSustentation The updated DocumentSustentation object.
     * @return The updated DocumentSustentation, if found.
     */
    DocumentSustentation updateSustentation(String id, DocumentSustentation updatedSustentation);

    /**
     * Deletes a DocumentProposal by ID.
     * @param id The ID of the DocumentProposal to delete.
     */
    void deleteProposal(String id);

    /**
     * Deletes a DocumentReport by ID.
     * @param id The ID of the DocumentReport to delete.
     */
    void deleteReport(String id);

    /**
     * Deletes a DocumentSustentation by ID.
     * @param id The ID of the DocumentSustentation to delete.
     */
    void deleteSustentation(String id);
}
