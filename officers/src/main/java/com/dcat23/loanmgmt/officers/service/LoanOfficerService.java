package com.dcat23.loanmgmt.officers.service;

import com.dcat23.loanmgmt.officers.dto.LoanOfficerCreationDTO;
import com.dcat23.loanmgmt.officers.dto.LoanOfficerUpdateDTO;
import com.dcat23.loanmgmt.officers.model.LoanOfficer;

public interface LoanOfficerService {
    LoanOfficer createLoanOfficer(LoanOfficerCreationDTO loanOfficerDTO);

    LoanOfficer getLoanOfficerById(Long id);

    LoanOfficer updateLoanOfficer(Long id, LoanOfficerUpdateDTO loanOfficerDTO);

    void deleteLoanOfficer(Long id);
}
