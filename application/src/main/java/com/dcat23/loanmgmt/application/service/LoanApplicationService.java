package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanApplication;

import java.util.List;

public interface LoanApplicationService {
    LoanApplication createLoanApplication(LoanApplicationCreationDTO loanApplicationDTO);

    LoanApplication getLoanApplicationById(Long id);

    List<LoanApplication> getLoanApplicationsByCustomerId(Long userId);

    LoanApplication updateLoanApplication(Long id, LoanApplicationUpdateDTO loanApplicationUpdateDTO);

    void deleteLoanApplication(Long id);
}
