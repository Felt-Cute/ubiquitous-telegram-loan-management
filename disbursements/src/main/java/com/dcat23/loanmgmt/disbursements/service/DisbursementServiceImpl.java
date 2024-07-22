package com.dcat23.loanmgmt.disbursements.service;

import com.dcat23.loanmgmt.disbursements.dto.DisburseLoanDTO;
import com.dcat23.loanmgmt.disbursements.model.Disbursement;
import com.dcat23.loanmgmt.disbursements.model.DisbursementStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisbursementServiceImpl implements DisbursementService {

    @Override
    public Disbursement disburseLoan(Long loanId, DisburseLoanDTO disburseLoanDTO) {
        return null;
    }

    @Override
    public Disbursement getDisbursementById(Long id) {
        return null;
    }

    @Override
    public List<Disbursement> getDisbursementsByLoanId(Long loanId) {
        return List.of();
    }

    @Override
    public Disbursement updateDisbursementStatus(Long id, DisbursementStatus status) {
        return null;
    }
}
