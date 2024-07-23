package com.dcat23.loanmgmt.application.exception;

import org.springframework.http.HttpStatus;

public class LoanApplicationNotFoundException extends RuntimeException {
    public LoanApplicationNotFoundException(Long id) {
        super(String.format("LoanApplication with id '%s' not found", id));
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
