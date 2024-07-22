package com.dcat23.loanmgmt.application.exception;

public class LoanProductNotFoundException extends RuntimeException {
    public LoanProductNotFoundException(Long id) {
        super(String.format("Loan product with id %s not found", id));
    }
}
