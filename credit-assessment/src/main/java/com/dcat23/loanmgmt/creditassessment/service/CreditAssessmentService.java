package com.dcat23.loanmgmt.creditassessment.service;

import com.dcat23.loanmgmt.creditassessment.dto.CreditAssessmentCreationDTO;
import com.dcat23.loanmgmt.creditassessment.dto.CreditAssessmentUpdateDTO;
import com.dcat23.loanmgmt.creditassessment.model.CreditAssessment;

public interface CreditAssessmentService {
    CreditAssessment saveCreditAssessment(CreditAssessmentCreationDTO creditAssessmentDTO);

    CreditAssessment getCreditAssessmentById(Long id);

    CreditAssessment getCreditAssessmentByApplicationId(Long applicationId);

    CreditAssessment updateCreditAssessment(Long id, CreditAssessmentUpdateDTO creditAssessmentDTO);
}
