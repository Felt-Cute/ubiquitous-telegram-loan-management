package com.dcat23.loanmgmt.payments.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "TransactionUpdate",
        description = "Schema to hold updated transaction details")
public record TransactionUpdateDTO() {
}
