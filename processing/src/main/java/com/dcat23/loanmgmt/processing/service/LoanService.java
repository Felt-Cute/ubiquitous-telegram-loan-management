package com.dcat23.loanmgmt.processing.service;

import com.dcat23.loanmgmt.core.model.LoanStatus;
import com.dcat23.loanmgmt.processing.model.Loan;

import java.util.List;

public interface LoanService {
    Loan processLoanApplication(Long applicationId);

    Loan getLoanById(Long id);

    List<Loan> getLoansByUserId(Long userId);

    Loan updateLoanStatus(Long id, LoanStatus status);

    List<Loan> searchLoansByStatus(LoanStatus status);
}
