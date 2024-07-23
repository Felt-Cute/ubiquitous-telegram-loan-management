package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanProduct;

import java.util.List;

public interface LoanProductService {
    LoanProduct getLoanProductById(Long id);

    List<LoanProduct> getAllLoanProducts();

    LoanProduct createLoanProduct(LoanProductCreationDTO loanProductDTO);

    LoanProduct updateLoanProduct(Long id, LoanProductUpdateDTO loanProductDTO);

    void deleteLoanProduct(Long id);
}
