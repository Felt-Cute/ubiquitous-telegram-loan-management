package com.dcat23.loanmgmt.application.dto;

import com.dcat23.loanmgmt.core.model.LoanStatus;

import java.time.LocalDate;

public record LoanApplicationResponse(
        Double amount,
        Integer term,
        LoanStatus status,
        String loanProductName,
        LocalDate applicationDate
) {
}
