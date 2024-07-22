package com.dcat23.loanmgmt.disbursements.service;

import com.dcat23.loanmgmt.disbursements.dto.DisburseLoanDTO;
import com.dcat23.loanmgmt.disbursements.model.Disbursement;
import com.dcat23.loanmgmt.disbursements.model.DisbursementStatus;

import java.util.List;

public interface DisbursementService {
    Disbursement disburseLoan(Long loanId, DisburseLoanDTO disburseLoanDTO);

    Disbursement getDisbursementById(Long id);

    List<Disbursement> getDisbursementsByLoanId(Long loanId);

    Disbursement updateDisbursementStatus(Long id, DisbursementStatus status);
}
