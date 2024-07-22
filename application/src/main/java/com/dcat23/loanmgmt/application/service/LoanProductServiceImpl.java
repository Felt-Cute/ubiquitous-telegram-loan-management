package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.exception.LoanProductNotFoundException;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.repository.LoanProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanProductServiceImpl implements LoanProductService {

    private final LoanProductRepository loanProductRepository;

    @Override
    public LoanProduct getLoanProductById(Long id) {
        return loanProductRepository.findById(id)
                .orElseThrow(() -> new LoanProductNotFoundException(id));
    }
}
