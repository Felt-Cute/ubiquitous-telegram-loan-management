package com.dcat23.loanmgmt.processing.repository;

import com.dcat23.loanmgmt.processing.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
