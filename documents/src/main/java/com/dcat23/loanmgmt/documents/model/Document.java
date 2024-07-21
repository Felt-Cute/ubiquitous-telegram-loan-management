package com.dcat23.loanmgmt.documents.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @Column(nullable = false, name = "loan_id")
    private Long loanId; // Reference to the loan in LoanProcessingService

    @Column(nullable = false, name = "document_type")
    private String documentType;

    @Column(nullable = false, name = "file_name")
    private String fileName;

    @Column(nullable = false, name = "upload_date")
    private LocalDate uploadDate;

}
