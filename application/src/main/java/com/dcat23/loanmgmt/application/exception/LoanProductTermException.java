package com.dcat23.loanmgmt.application.exception;

import com.dcat23.loanmgmt.application.model.LoanProduct;

public class LoanProductTermException extends LoanProductRequirementException {

    public LoanProductTermException(LoanProduct product, Integer term) {
        super(product, "Term '"+term+"' not allowed");
    }

    @Override
    public String getDetails() {
        if (this.loanProduct != null) {
            return String.format("Term must be between %d to %d months for %s",
                    loanProduct.getMinTerm(), loanProduct.getMaxTerm(), loanProduct.getName());
        }
        return super.getDetails();
    }
}
