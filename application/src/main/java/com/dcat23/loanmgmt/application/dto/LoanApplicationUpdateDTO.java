package com.dcat23.loanmgmt.application.dto;

import com.dcat23.loanmgmt.core.model.LoanStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

@Schema(
        name = "LoanApplicationUpdate",
        description = "Schema to hold Loan Application updated details")
public record LoanApplicationUpdateDTO(

        @Min(value = 0, message = "Amount must be greater than 0")
        Double amount,

        @Min(value = 1, message = "Term must be greater than 1")
        Integer term,

        LoanStatus loanStatus,

        Long loanProductId

) {
}
