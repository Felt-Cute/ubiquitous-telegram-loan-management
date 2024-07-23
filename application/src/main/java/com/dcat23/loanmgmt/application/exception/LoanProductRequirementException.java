package com.dcat23.loanmgmt.application.exception;

import com.dcat23.loanmgmt.application.model.LoanProduct;
import org.springframework.http.HttpStatus;

public class LoanProductRequirementException extends RuntimeException {

    protected final LoanProduct loanProduct;

    public LoanProductRequirementException(String message) {
        super(message);
        loanProduct = null;
    }

    public LoanProductRequirementException(LoanProduct product, String message) {
        super(message);
        this.loanProduct = product;
    }

    public String getDetails() {
        return super.getMessage();
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
