package com.dcat23.loanmgmt.processing.service;

import com.dcat23.loanmgmt.core.model.LoanStatus;
import com.dcat23.loanmgmt.processing.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    @Override
    public Loan processLoanApplication(Long applicationId) {
        return null;
    }

    @Override
    public Loan getLoanById(Long id) {
        return null;
    }

    @Override
    public List<Loan> getLoansByUserId(Long userId) {
        return List.of();
    }

    @Override
    public Loan updateLoanStatus(Long id, LoanStatus status) {
        return null;
    }

    @Override
    public List<Loan> searchLoansByStatus(LoanStatus status) {
        return List.of();
    }
}
