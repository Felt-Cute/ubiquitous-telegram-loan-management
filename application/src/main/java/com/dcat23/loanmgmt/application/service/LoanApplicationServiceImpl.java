package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.mapper.LoanApplicationMapper;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.repository.LoanApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanApplicationServiceImpl implements LoanApplicationService {

    private final LoanProductService loanProductService;
    private final LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication createLoanApplication(LoanApplicationCreationDTO loanApplicationDTO) {
        LoanApplication loanApplication = LoanApplicationMapper
                .mapToLoanApplication(loanApplicationDTO, new LoanApplication());
        LoanProduct loanProduct = loanProductService.getLoanProductById(loanApplicationDTO.loanProductId());
        loanProduct.addApplication(loanApplication);
        return loanApplicationRepository.save(loanApplication);
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
