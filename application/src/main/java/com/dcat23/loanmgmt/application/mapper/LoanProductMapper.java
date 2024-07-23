package com.dcat23.loanmgmt.application.mapper;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.model.LoanProduct;

public class LoanProductMapper {
    public static LoanProduct mapToLoanProduct(LoanProductCreationDTO loanProductDTO, LoanProduct loanProduct) {
        loanProduct.setName(loanProductDTO.name());
        loanProduct.setInterestRate(loanProductDTO.interestRate());
        loanProduct.setMinAmount(loanProductDTO.minAmount());
        loanProduct.setMaxAmount(loanProductDTO.maxAmount());
        loanProduct.setMinTerm(loanProductDTO.minTerm());
        loanProduct.setMaxTerm(loanProductDTO.maxTerm());
        return loanProduct;
    }
}
