package com.dcat23.loanmgmt.application.service.impl;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductResponse;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;
import com.dcat23.loanmgmt.application.exception.LoanProductNotFoundException;
import com.dcat23.loanmgmt.application.exception.LoanProductRequirementException;
import com.dcat23.loanmgmt.application.mapper.LoanProductMapper;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.repository.LoanProductRepository;
import com.dcat23.loanmgmt.application.service.client.LoanProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanProductServiceImpl implements LoanProductService {

    private final LoanProductMapper loanProductMapper = LoanProductMapper.INSTANCE;

    private final LoanProductRepository loanProductRepository;

    @Override
    public LoanProductResponse getLoanProductById(Long id) {
        LoanProduct product = findById(id);
        return loanProductMapper.toResponse(product);
    }

    private LoanProduct findById(Long id) {
        return loanProductRepository.findById(id)
                .orElseThrow(() -> new LoanProductNotFoundException(id));
    }

    @Override
    public List<LoanProductResponse> getAllLoanProducts() {
        List<LoanProduct> all = loanProductRepository.findAll();
        return loanProductMapper.toResponseList(all);
    }

    @Override
    public LoanProductResponse createLoanProduct(LoanProductCreationDTO loanProductDTO) {
        LoanProduct loanProduct = loanProductMapper.toEntity(loanProductDTO);
        checkLoanProductRequirements(loanProduct);
        LoanProduct saved = loanProductRepository.save(loanProduct);
        return loanProductMapper.toResponse(saved);
    }

    private void checkLoanProductRequirements(LoanProduct loanProduct) {
        if (loanProduct.getInterestRate() < 0 || loanProduct.getInterestRate() > 3) {
            throw new LoanProductRequirementException("Interest rate must be between 0 and 3");
        }
        if (loanProduct.getMinAmount() >= loanProduct.getMaxAmount()) {
            throw new LoanProductRequirementException("Minimum AMOUNT must be less than maximum AMOUNT");
        }
        if (loanProduct.getMinTerm() >= loanProduct.getMaxTerm()) {
            throw new LoanProductRequirementException("Minimum TERM must be less than maximum TERM");
        }
    }

    @Override
    public LoanProductResponse updateLoanProduct(Long id, LoanProductUpdateDTO loanProductDTO) {
        LoanProduct loanProduct = findById(id);
        loanProductMapper.update(loanProductDTO, loanProduct);
        checkLoanProductRequirements(loanProduct);
        LoanProduct saved = loanProductRepository.save(loanProduct);
        return loanProductMapper.toResponse(saved);
    }

    @Override
    public void deleteLoanProduct(Long id) {
        LoanProduct loanProduct = findById(id);
        loanProduct.setIsActive(false);
        loanProductRepository.save(loanProduct);
    }
}
