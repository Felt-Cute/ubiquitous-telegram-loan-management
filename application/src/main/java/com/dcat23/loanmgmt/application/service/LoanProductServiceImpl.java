package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;
import com.dcat23.loanmgmt.application.exception.LoanProductNotFoundException;
import com.dcat23.loanmgmt.application.exception.LoanProductRequirementException;
import com.dcat23.loanmgmt.application.mapper.LoanProductMapper;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.repository.LoanProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanProductServiceImpl implements LoanProductService {

    private final LoanProductRepository loanProductRepository;

    @Override
    public LoanProduct getLoanProductById(Long id) {
        return loanProductRepository.findById(id)
                .orElseThrow(() -> new LoanProductNotFoundException(id));
    }

    @Override
    public List<LoanProduct> getAllLoanProducts() {
        return loanProductRepository.findAll();
    }

    @Override
    public LoanProduct createLoanProduct(LoanProductCreationDTO loanProductDTO) {
        LoanProduct loanProduct = LoanProductMapper.mapToLoanProduct(loanProductDTO, new LoanProduct());
        checkLoanProductRequirements(loanProduct);
        return loanProductRepository.save(loanProduct);
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
    public LoanProduct updateLoanProduct(Long id, LoanProductUpdateDTO loanProductDTO) {
        LoanProduct loanProduct = getLoanProductById(id);
        LoanProductMapper.mapToLoanProduct(loanProductDTO, loanProduct);
        checkLoanProductRequirements(loanProduct);
        return loanProductRepository.save(loanProduct);
    }

    @Override
    public void deleteLoanProduct(Long id) {
        loanProductRepository.deleteById(id);
    }
}
