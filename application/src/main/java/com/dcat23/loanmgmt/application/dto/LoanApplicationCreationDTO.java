package com.dcat23.loanmgmt.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Schema(
        name = "LoanApplicationCreation",
        description = "Schema to hold Loan Application details")
public record LoanApplicationCreationDTO(

        @NotBlank(message = "amount must not be empty")
        @Min(value = 0, message = "Amount must be greater than 0")
        Double amount,

        @NotBlank(message = "interest rate must not be empty")
        @Min(value = 0, message = "interest rate must be greater than 0")
        Double interestRate,

        @NotBlank(message = "term must not be empty")
        @Min(value = 1, message = "Term must be greater than 1")
        Integer term,

        LocalDate startDate,

        LocalDate endDate,

        @NotBlank(message = "customer id must not be empty")
        Long customerId

) {
}
