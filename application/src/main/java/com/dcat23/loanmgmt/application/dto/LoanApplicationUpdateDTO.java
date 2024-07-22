package com.dcat23.loanmgmt.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "LoanApplicationUpdate",
        description = "Schema to hold Loan Application updated details")
public record LoanApplicationUpdateDTO() {
}
