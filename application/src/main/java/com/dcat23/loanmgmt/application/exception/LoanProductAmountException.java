package com.dcat23.loanmgmt.application.exception;

import com.dcat23.loanmgmt.application.model.LoanProduct;

public class LoanProductAmountException extends LoanProductRequirementException {
    public LoanProductAmountException(LoanProduct product, Double amount) {
        super(product, "Amount " + amount + "' not allowed");
    }

    @Override
    public String getDetails() {
        if (this.loanProduct != null) {
            return String.format("Amount must be between $%.2f - $%.2f for %s",
                    loanProduct.getMinAmount(), loanProduct.getMaxAmount(), loanProduct.getName());
        }
        return super.getDetails();
    }
}
