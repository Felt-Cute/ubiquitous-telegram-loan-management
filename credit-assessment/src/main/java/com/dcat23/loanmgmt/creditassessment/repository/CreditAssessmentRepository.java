package com.dcat23.loanmgmt.creditassessment.repository;

import com.dcat23.loanmgmt.creditassessment.model.CreditAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditAssessmentRepository extends JpaRepository<CreditAssessment, Long> {
}
