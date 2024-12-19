package com.unibague.gradework.orionserver.service;

import com.unibague.gradework.orionserver.model.*;
import com.unibague.gradework.orionserver.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the DocumentService interface.
 * This class handles the business logic for managing documents, including proposals, reports, and sustentations.
 * It provides methods to create, retrieve, update, and delete records for each document type.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentProposalRepository proposalRepository;

    @Autowired
    private DocumentReportRepository reportRepository;

    @Autowired
    private DocumentSustentationRepository sustentationRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private TypeDocumentRepository typeDocumentRepository;

    /**
     * Creates a new DocumentProposal.
     *
     * @param proposal The DocumentProposal object to save.
     * @return The saved DocumentProposal.
     */
    @Override
    public DocumentProposal createProposal(DocumentProposal proposal, String typeName) {
        TypeDocument typeDocument = typeDocumentRepository.findByName(typeName)
                .orElseThrow(() -> new RuntimeException("TypeDocument '" + typeName + "' not found"));
        proposal.setType(typeDocument); // Asigna el TypeDocument encontrado al proposal
        return proposalRepository.save(proposal); // Guarda el documento en la base de datos
    }

    /**
     * Creates a new DocumentReport.
     *
     * @param report The DocumentReport object to save.
     * @return The saved DocumentReport.
     */
    @Override
    public DocumentReport createReport(DocumentReport report, String typeName) {
        TypeDocument typeDocument = typeDocumentRepository.findByName(typeName)
                .orElseThrow(() -> new RuntimeException("TypeDocument '" + typeName + "' not found"));
        report.setType(typeDocument); // Asigna el TypeDocument encontrado al report
        return reportRepository.save(report); // Guarda el documento en la base de datos
    }

    /**
     * Creates a new DocumentSustentation.
     *
     * @param sustentation The DocumentSustentation object to save.
     * @return The saved DocumentSustentation.
     */
    @Override
    public DocumentSustentation createSustentation(DocumentSustentation sustentation, String typeName) {
        TypeDocument typeDocument = typeDocumentRepository.findByName(typeName)
                .orElseThrow(() -> new RuntimeException("TypeDocument '" + typeName + "' not found"));
        sustentation.setType(typeDocument); // Asigna el TypeDocument encontrado al sustentation
        return sustentationRepository.save(sustentation); // Guarda el documento en la base de datos
    }

    /**
     * Retrieves all documents, regardless of their specific type.
     *
     * @return A list of all Document objects.
     */
    @Override
    public List<Documents> getAllDocuments() {
        return documentRepository.findAll();
    }

    /**
     * Retrieves all DocumentProposal records.
     *
     * @return A list of all DocumentProposal objects.
     */
    @Override
    public List<DocumentProposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    /**
     * Retrieves all DocumentReport records.
     *
     * @return A list of all DocumentReport objects.
     */
    @Override
    public List<DocumentReport> getAllReports() {
        return reportRepository.findAll();
    }

    /**
     * Retrieves all DocumentSustentation records.
     *
     * @return A list of all DocumentSustentation objects.
     */
    @Override
    public List<DocumentSustentation> getAllSustentations() {
        return sustentationRepository.findAll();
    }

    /**
     * Updates an existing DocumentProposal.
     *
     * @param id              The ID of the DocumentProposal to update.
     * @param updatedProposal The updated DocumentProposal object containing new values.
     * @return An Optional containing the updated DocumentProposal, or empty if not found.
     */
    @Override
    public DocumentProposal updateProposal(String id, DocumentProposal updatedProposal) {
        DocumentProposal existingProposal = proposalRepository.findById(String.valueOf(Long.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Report with ID " + id + " not found"));

        existingProposal.setDocument(updatedProposal.getDocument());
        existingProposal.setDateRelease(updatedProposal.getDateRelease());
        existingProposal.setStatusDocument(updatedProposal.getStatusDocument());
        existingProposal.setIdProposalReport(updatedProposal.getIdProposalReport());
        return proposalRepository.save(existingProposal);
    }

    /**
     * Updates an existing DocumentReport.
     *
     * @param id            The ID of the DocumentReport to update.
     * @param updatedReport The updated DocumentReport object containing new values.
     * @return An Optional containing the updated DocumentReport, or empty if not found.
     */
    @Override
    public DocumentReport updateReport(String id, DocumentReport updatedReport) {
        DocumentReport existingReport = reportRepository.findById(String.valueOf(Long.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Report with ID " + id + " not found"));

        existingReport.setDocument(updatedReport.getDocument());
        existingReport.setDateRelease(updatedReport.getDateRelease());
        existingReport.setStatusDocument(updatedReport.getStatusDocument());
        existingReport.setIdWorkReport(updatedReport.getIdWorkReport());
        return reportRepository.save(existingReport);
    }

    /**
     * Updates an existing DocumentSustentation.
     *
     * @param id                  The ID of the DocumentSustentation to update.
     * @param updatedSustentation The updated DocumentSustentation object containing new values.
     * @return An Optional containing the updated DocumentSustentation, or empty if not found.
     */
    @Override
    public DocumentSustentation updateSustentation(String id, DocumentSustentation updatedSustentation) {
        DocumentSustentation existingSustentation = sustentationRepository.findById(String.valueOf(Long.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Sustentation with ID " + id + " not found"));

        existingSustentation.setDocument(updatedSustentation.getDocument());
        existingSustentation.setDateRelease(updatedSustentation.getDateRelease());
        existingSustentation.setStatusDocument(updatedSustentation.getStatusDocument());
        existingSustentation.setIdWorkSustentation(updatedSustentation.getIdWorkSustentation());

        return sustentationRepository.save(existingSustentation);
    }

    /**
     * Deletes a DocumentProposal by its ID.
     *
     * @param id The ID of the DocumentProposal to delete.
     */
    @Override
    public void deleteProposal(String id) {
        proposalRepository.deleteById(id);
    }

    /**
     * Deletes a DocumentReport by its ID.
     *
     * @param id The ID of the DocumentReport to delete.
     */
    @Override
    public void deleteReport(String id) {
        reportRepository.deleteById(id);
    }

    /**
     * Deletes a DocumentSustentation by its ID.
     *
     * @param id The ID of the DocumentSustentation to delete.
     */
    @Override
    public void deleteSustentation(String id) {
        sustentationRepository.deleteById(id);
    }
}
