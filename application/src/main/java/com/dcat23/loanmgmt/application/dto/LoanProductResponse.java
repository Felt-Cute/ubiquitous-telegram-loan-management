package com.dcat23.loanmgmt.application.dto;

public record LoanProductResponse(
        String name,
        Double interestRate,
        Double minAmount,
        Double maxAmount,
        Integer minTerm,
        Integer maxTerm,
        Boolean isActive,
        Integer applications
) {
}
