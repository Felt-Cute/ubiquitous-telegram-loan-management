package com.dcat23.loanmgmt.disbursements.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "DisburseLoan",
        description = "Schema to hold details about a loan to Disburse")
public record DisburseLoanDTO() {
}
