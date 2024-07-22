package com.dcat23.loanmgmt.officers.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "LoanOfficerCreation",
        description = "Schema to hold details to create a Loan Officer ")
public record LoanOfficerCreationDTO() {
}
