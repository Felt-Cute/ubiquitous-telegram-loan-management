package com.dcat23.loanmgmt.documents.repository;

import com.dcat23.loanmgmt.documents.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
