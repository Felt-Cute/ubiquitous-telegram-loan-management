package com.dcat23.loanmgmt.documents.controller;

import com.dcat23.loanmgmt.documents.dto.DocumentUploadDTO;
import com.dcat23.loanmgmt.documents.model.Document;
import com.dcat23.loanmgmt.documents.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    @Operation(
                summary = "Upload Document",
                description = "REST API to upload loan application documents")
    @ApiResponse(
                responseCode = "202",
                description = "HTTP Status ACCEPTED")
    public ResponseEntity<Document> uploadDocument(@Valid @RequestBody DocumentUploadDTO document) {
        Document savedDocument = documentService.uploadDocument(document);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedDocument);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Document By Id",
                description = "REST API to FETCH document")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        return ResponseEntity.ok(document);
    }

    @GetMapping("/loan/{loanId}")
    @Operation(
                summary = "Get Documents By Loan Id",
                description = "REST API to FETCH documents for a specific Loan")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<List<Document>> getDocumentsByLoanId(@PathVariable Long loanId) {
        List<Document> documents = documentService.getDocumentsByLoanId(loanId);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/application/{applicationId}")
    @Operation(
                summary = "Get Documents By Application Id",
                description = "REST API to FETCH Documents from a Loan Application")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<List<Document>> getDocumentsByApplicationId(@PathVariable Long applicationId) {
        List<Document> documents = documentService.getDocumentsByApplicationId(applicationId);
        return ResponseEntity.ok(documents);
    }

    @DeleteMapping("/{id}")
    @Operation(
                summary = "Delete Document",
                description = "REST API to delete a Document")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status NO CONTENT")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/verify")
    @Operation(
                summary = "Verify Document",
                description = "REST API to verify document")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Document> verifyDocument(@PathVariable Long id) {
        Document verifiedDocument = documentService.verifyDocument(id);
        return ResponseEntity.ok(verifiedDocument);
    }
}

