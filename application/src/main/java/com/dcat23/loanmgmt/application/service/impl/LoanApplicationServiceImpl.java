package com.dcat23.loanmgmt.application.service.impl;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationResponse;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.exception.*;
import com.dcat23.loanmgmt.application.mapper.LoanApplicationMapper;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.repository.LoanApplicationRepository;
import com.dcat23.loanmgmt.application.repository.LoanProductRepository;
import com.dcat23.loanmgmt.application.service.client.LoanApplicationService;
import com.dcat23.loanmgmt.core.model.LoanStatus;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private static final LoanApplicationMapper loanApplicationMapper = LoanApplicationMapper.INSTANCE;

    private final LoanProductRepository loanProductRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplicationResponse createLoanApplication(LoanApplicationCreationDTO loanApplicationDTO) {
        LoanApplication loanApplication = loanApplicationMapper.toEntity(loanApplicationDTO);
        LoanProduct loanProduct = findLoanProductById(loanApplicationDTO.loanProductId());
        checkLoanProductRequirements(loanProduct, loanApplication);
        loanProduct.addApplication(loanApplication);
        LoanApplication saved = loanApplicationRepository.save(loanApplication);
        return loanApplicationMapper.toResponse(saved);
    }

    private void checkLoanProductRequirements(LoanProduct product, LoanApplication application) throws LoanProductRequirementException {
        if (application.getTerm() > product.getMaxTerm() || application.getTerm() < product.getMinTerm()) {
            throw new LoanProductTermException(product, application.getTerm());
        }

        if (application.getAmount() > product.getMaxAmount() || application.getAmount() < product.getMinAmount()) {
            throw new LoanProductAmountException(product, application.getAmount());
        }
    }

    private LoanProduct findLoanProductById(Long productId) {
        return loanProductRepository.findById(productId)
                .orElseThrow(() -> new LoanProductNotFoundException(productId));
    }

    @Override
    public LoanApplicationResponse getLoanApplicationById(Long id) throws LoanApplicationNotFoundException {
        LoanApplication application = findById(id);
        return loanApplicationMapper.toResponse(application);
    }

    private LoanApplication findById(Long id) {
        return loanApplicationRepository.findById(id)
                .orElseThrow(() -> new LoanApplicationNotFoundException(id));
    }

    @Override
    public List<LoanApplicationResponse> getLoanApplicationsByCustomerId(Long customerId) {
        List<LoanApplication> allByCustomerId = loanApplicationRepository
                .findAllByCustomerId(customerId);
        return loanApplicationMapper.toResponse(allByCustomerId);
    }

    @Override
    @Transactional
    public LoanApplicationResponse updateLoanApplication(Long id, LoanApplicationUpdateDTO loanApplicationUpdateDTO) {
        LoanApplication loanApplication = findById(id);
        loanApplicationMapper.update(loanApplicationUpdateDTO, loanApplication);

        LoanProduct loanProduct = updateLoanProduct(
                loanApplicationUpdateDTO.loanProductId(),
                loanApplication);

        checkLoanProductRequirements(loanProduct, loanApplication);

        LoanApplication saved = loanApplicationRepository.save(loanApplication);
        return loanApplicationMapper.toResponse(saved);
    }


    private LoanProduct updateLoanProduct(Long updatedLoanProductId, LoanApplication loanApplication) {
        LoanProduct loanProduct = loanApplication.getLoanProduct();

        if (updatedLoanProductId == null) return loanProduct;

        if (!loanProduct.getId().equals(updatedLoanProductId)) {
            loanProduct.removeApplication(loanApplication);
            loanProductRepository.save(loanProduct);

            LoanProduct updatedLoanProduct = findLoanProductById(updatedLoanProductId);
            updatedLoanProduct.addApplication(loanApplication);
            return updatedLoanProduct;
        }
        return loanProduct;
    }

    @Override
    public void cancelLoanApplication(Long id) {
        LoanApplication loanApplication = findById(id);
        switch (loanApplication.getStatus()) {
            case ACTIVE:
            case PENDING:
                loanApplication.setStatus(LoanStatus.CANCELLED);
        }
        loanApplicationRepository.save(loanApplication);
    }
}
