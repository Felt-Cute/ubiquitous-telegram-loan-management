package com.dcat23.loanmgmt.application.dto;

import com.dcat23.loanmgmt.core.validation.annotations.FutureOrPresentLocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

@Schema(
        name = "LoanApplicationCreation",
        description = "Schema to hold Loan Application details")
public record LoanApplicationCreationDTO(

        @Schema(description = "Loan amount in $$")
        @NotBlank(message = "amount must not be empty")
        @Min(value = 0, message = "Amount must be greater than 0")
        Double amount,

        @Schema(description = "Loan term in months")
        @NotBlank(message = "term must not be empty")
        @Min(value = 1, message = "Term must be greater than 1")
        Integer term,

        @Schema(description = "the Customer id")
        @NotBlank(message = "customer id must not be empty")
        Long customerId,

        @Schema(description = "Loan product id")
        @NotBlank(message = "Loan product id must not be empty")
        Long loanProductId
) {
}
