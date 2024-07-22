package com.dcat23.loanmgmt.application.mapper;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import com.dcat23.loanmgmt.core.model.LoanStatus;

import java.time.LocalDate;

public class LoanApplicationMapper {

    public static LoanApplication mapToLoanApplication(
            LoanApplicationCreationDTO loanApplicationDTO,
            LoanApplication loanApplication
    ) {
        loanApplication.setAmount(loanApplicationDTO.amount());
        loanApplication.setTerm(loanApplicationDTO.term());
        loanApplication.setStatus(LoanStatus.PENDING);
        loanApplication.setCustomerId(loanApplicationDTO.customerId());
        loanApplication.setApplicationDate(LocalDate.now());
        return loanApplication;
    }
}
