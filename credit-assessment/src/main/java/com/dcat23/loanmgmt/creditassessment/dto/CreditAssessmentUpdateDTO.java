package com.dcat23.loanmgmt.creditassessment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(
        name = "CreditAssessmentUpdate",
        description = "Schema to hold information to update a credit assessment")
public record CreditAssessmentUpdateDTO(

        Long loanApplicationId,

        Long customerId,

        String assessmentResult,

        LocalDate assessmentDate
) {
}
