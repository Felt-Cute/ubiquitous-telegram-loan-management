package com.dcat23.loanmgmt.application.mapper;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;
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

    public static void mapToLoanProduct(LoanProductUpdateDTO loanProductDTO, LoanProduct loanProduct) {
        if (loanProductDTO == null || loanProduct == null) return;

        if (loanProductDTO.interestRate() != null) {
            loanProduct.setInterestRate(loanProductDTO.interestRate());
        }

        if (loanProductDTO.minAmount() != null) {
            loanProduct.setMinAmount(loanProductDTO.minAmount());
        }

        if (loanProductDTO.maxAmount() != null) {
            loanProduct.setMaxAmount(loanProductDTO.maxAmount());
        }

        if (loanProductDTO.minTerm() != null) {
            loanProduct.setMinTerm(loanProductDTO.minTerm());
        }

        if (loanProductDTO.maxTerm() != null) {
            loanProduct.setMaxTerm(loanProductDTO.maxTerm());
        }

        if (loanProductDTO.name() != null) {
            loanProduct.setName(loanProductDTO.name());
        }

    }
}
