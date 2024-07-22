package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.exception.*;
import com.dcat23.loanmgmt.application.mapper.LoanApplicationMapper;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.repository.LoanApplicationRepository;
import com.dcat23.loanmgmt.application.repository.LoanProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final LoanProductRepository loanProductRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication createLoanApplication(LoanApplicationCreationDTO loanApplicationDTO) {
        LoanApplication loanApplication = LoanApplicationMapper
                .mapToLoanApplication(loanApplicationDTO, new LoanApplication());

        LoanProduct loanProduct = getLoanProductById(loanApplicationDTO.loanProductId());

        checkLoanProductRequirements(loanProduct, loanApplication);

        loanProduct.addApplication(loanApplication);
        return loanApplicationRepository.save(loanApplication);
    }

    private void checkLoanProductRequirements(LoanProduct product, LoanApplication application) throws LoanProductRequirementException {
        if (application.getTerm() > product.getMaxTerm() || application.getTerm() < product.getMinTerm()) {
            throw new LoanProductTermException(product, application.getTerm());
        }

        if (application.getAmount() > product.getMaxAmount() || application.getAmount() < product.getMinAmount()) {
            throw new LoanProductAmountException(product, application.getAmount());
        }
    }

    private LoanProduct getLoanProductById(Long productId) {
        return loanProductRepository.findById(productId)
                .orElseThrow(() -> new LoanProductNotFoundException(productId));
    }

    @Override
    public LoanApplication getLoanApplicationById(Long id) throws LoanApplicationNotFoundException {
        return loanApplicationRepository.findById(id)
                .orElseThrow(() -> new LoanApplicationNotFoundException(id));
    }

    @Override
    public List<LoanApplication> getLoanApplicationsByCustomerId(Long customerId) {
        return loanApplicationRepository.findAllByCustomerId(customerId);
    }

    @Override
    public LoanApplication updateLoanApplication(Long id, LoanApplicationUpdateDTO loanApplicationUpdateDTO) {
        return null;
    }

    @Override
    public void deleteLoanApplication(Long id) {

    }
}
