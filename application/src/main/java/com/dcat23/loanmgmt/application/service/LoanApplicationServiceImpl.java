package com.dcat23.loanmgmt.application.service;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Override
    public LoanApplication createLoanApplication(LoanApplicationCreationDTO loanApplicationDTO) {
        return null;
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
