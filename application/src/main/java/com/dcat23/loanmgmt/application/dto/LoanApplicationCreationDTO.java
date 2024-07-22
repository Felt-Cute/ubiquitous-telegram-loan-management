package com.dcat23.loanmgmt.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "LoanApplicationCreation",
        description = "Schema to hold Loan Application details")
public record LoanApplicationCreationDTO() {
}
