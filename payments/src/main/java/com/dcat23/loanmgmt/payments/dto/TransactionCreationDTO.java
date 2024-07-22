package com.dcat23.loanmgmt.payments.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "TransactionCreation",
        description = "Schema to hold details for a new transaction")
public record TransactionCreationDTO() {
}
