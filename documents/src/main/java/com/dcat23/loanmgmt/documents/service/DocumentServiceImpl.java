package com.dcat23.loanmgmt.documents.service;

import com.dcat23.loanmgmt.documents.dto.DocumentUploadDTO;
import com.dcat23.loanmgmt.documents.model.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Override
    public Document getDocumentById(Long id) {
        return null;
    }

    @Override
    public Document uploadDocument(DocumentUploadDTO document) {
        return null;
    }

    @Override
    public List<Document> getDocumentsByLoanId(Long loanId) {
        return List.of();
    }

    @Override
    public List<Document> getDocumentsByApplicationId(Long applicationId) {
        return List.of();
    }

    @Override
    public void deleteDocument(Long id) {

    }

    @Override
    public Document verifyDocument(Long id) {
        return null;
    }
}
