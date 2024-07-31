package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductResponse;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;

import java.util.List;

public interface LoanProductService {
    LoanProductResponse getLoanProductById(Long id);

    List<LoanProductResponse> getAllLoanProducts();

    LoanProductResponse createLoanProduct(LoanProductCreationDTO loanProductDTO);

    LoanProductResponse updateLoanProduct(Long id, LoanProductUpdateDTO loanProductDTO);

    void deleteLoanProduct(Long id);
}
