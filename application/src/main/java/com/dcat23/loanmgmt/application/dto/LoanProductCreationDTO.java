package com.dcat23.loanmgmt.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(
    name = "LoanProductCreation",
    description = "Schema to hold Loan Product details")
public record LoanProductCreationDTO(

        @Schema(description = "Loan product name")
        @NotNull
        @NotBlank(message = "Name must not be empty")
        String name,

        @Schema(description = "Interest rate (0-300%)", example = "0.05")
        @Min(value = 0, message = "Interest rate must be greater than 0")
        @Max(value = 3, message = "Interest rate must be less than 3 (300%)")
        @NotNull
        Double interestRate,

        @Schema(description = "Minimum loan amount", example = "2000.00")
        @Min(value = 0, message = "Min loan amount must be greater than 0")
        @NotNull
        Double minAmount,

        @Schema(description = "Maximum loan amount", example = "25000.00")
        @Min(value = 0, message = "Max loan amount must be greater than 0")
        @NotNull
        Double maxAmount,

        @Schema(description = "Shortest term length", example = "12")
        @Min(value = 0, message = "Min loan term must be greater than 0")

        Integer minTerm,

        @Schema(description = "Longest term length", example = "72")
        @Min(value = 0, message = "Max loan term must be greater than 0")
        Integer maxTerm

) {
}
