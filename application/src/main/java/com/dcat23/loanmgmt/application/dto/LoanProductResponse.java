package com.dcat23.loanmgmt.application.dto;

import java.util.List;

public record LoanProductResponse(
        String name,
        Double interestRate,
        Double minAmount,
        Double maxAmount,
        Integer minTerm,
        Integer maxTerm,
        Boolean isActive,
        List<LoanApplicationResponse> applications
) {
}
