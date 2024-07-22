package com.dcat23.loanmgmt.application.exception;

import org.springframework.http.HttpStatus;

public class LoanProductNotFoundException extends RuntimeException {
    public LoanProductNotFoundException(Long id) {
        super(String.format("Loan product with id %s not found", id));
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
