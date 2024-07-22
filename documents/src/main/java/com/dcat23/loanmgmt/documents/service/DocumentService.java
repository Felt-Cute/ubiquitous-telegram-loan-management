package com.dcat23.loanmgmt.documents.service;

import com.dcat23.loanmgmt.documents.dto.DocumentUploadDTO;
import com.dcat23.loanmgmt.documents.model.Document;

import java.util.List;

public interface DocumentService {
    Document getDocumentById(Long id);

    Document uploadDocument(DocumentUploadDTO document);

    List<Document> getDocumentsByLoanId(Long loanId);

    List<Document> getDocumentsByApplicationId(Long applicationId);

    void deleteDocument(Long id);

    Document verifyDocument(Long id);
}
