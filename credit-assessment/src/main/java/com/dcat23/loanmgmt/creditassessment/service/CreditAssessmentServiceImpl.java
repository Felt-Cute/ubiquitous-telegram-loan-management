package com.dcat23.loanmgmt.creditassessment.service;

import com.dcat23.loanmgmt.creditassessment.dto.CreditAssessmentCreationDTO;
import com.dcat23.loanmgmt.creditassessment.dto.CreditAssessmentUpdateDTO;
import com.dcat23.loanmgmt.creditassessment.model.CreditAssessment;
import org.springframework.stereotype.Service;

@Service
public class CreditAssessmentServiceImpl implements CreditAssessmentService {

    @Override
    public CreditAssessment saveCreditAssessment(CreditAssessmentCreationDTO creditAssessmentDTO) {
        return null;
    }

    @Override
    public CreditAssessment getCreditAssessmentById(Long id) {
        return null;
    }

    @Override
    public CreditAssessment getCreditAssessmentByApplicationId(Long applicationId) {
        return null;
    }

    @Override
    public CreditAssessment updateCreditAssessment(Long id, CreditAssessmentUpdateDTO creditAssessmentDTO) {
        return null;
    }
}
