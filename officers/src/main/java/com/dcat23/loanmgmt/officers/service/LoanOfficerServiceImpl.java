package com.dcat23.loanmgmt.officers.service;

import com.dcat23.loanmgmt.officers.dto.LoanOfficerCreationDTO;
import com.dcat23.loanmgmt.officers.dto.LoanOfficerUpdateDTO;
import com.dcat23.loanmgmt.officers.model.LoanOfficer;
import org.springframework.stereotype.Service;

@Service
public class LoanOfficerServiceImpl implements LoanOfficerService {

    @Override
    public LoanOfficer createLoanOfficer(LoanOfficerCreationDTO loanOfficerDTO) {
        return null;
    }

    @Override
    public LoanOfficer getLoanOfficerById(Long id) {
        return null;
    }

    @Override
    public LoanOfficer updateLoanOfficer(Long id, LoanOfficerUpdateDTO loanOfficerDTO) {
        return null;
    }

    @Override
    public void deleteLoanOfficer(Long id) {

    }
}
