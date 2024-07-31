package com.dcat23.loanmgmt.application.service.client;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationResponse;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;

import java.util.List;

public interface LoanApplicationService {
    LoanApplicationResponse createLoanApplication(LoanApplicationCreationDTO loanApplicationDTO);

    LoanApplicationResponse getLoanApplicationById(Long id);

    List<LoanApplicationResponse> getLoanApplicationsByCustomerId(Long userId);

    LoanApplicationResponse updateLoanApplication(Long id, LoanApplicationUpdateDTO loanApplicationUpdateDTO);

    void cancelLoanApplication(Long id);
}
