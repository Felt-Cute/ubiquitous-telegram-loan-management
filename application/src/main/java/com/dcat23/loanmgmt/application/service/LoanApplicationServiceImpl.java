package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.exception.LoanProductAmountException;
import com.dcat23.loanmgmt.application.exception.LoanProductNotFoundException;
import com.dcat23.loanmgmt.application.exception.LoanProductTermException;
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

    private void checkLoanProductRequirements(LoanProduct product, LoanApplication application) {
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
    public LoanApplication getLoanApplicationById(Long id) {
        return null;
    }

    @Override
    public List<LoanApplication> getLoanApplicationsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public LoanApplication updateLoanApplication(Long id, LoanApplicationUpdateDTO loanApplicationUpdateDTO) {
        return null;
    }

    @Override
    public void deleteLoanApplication(Long id) {

    }
}
