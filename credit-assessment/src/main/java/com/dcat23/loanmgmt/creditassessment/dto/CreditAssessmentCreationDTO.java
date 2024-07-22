package com.dcat23.loanmgmt.creditassessment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(
        name = "CreditAssessmentCreation",
        description = "Schema to hold details to create a credit assessment")
public record CreditAssessmentCreationDTO(

        @NotBlank(message = "Application id must not be empty")
        Long loanApplicationId,

        @NotBlank(message = "Customer id must not be empty")
        Long customerId
) {
}
