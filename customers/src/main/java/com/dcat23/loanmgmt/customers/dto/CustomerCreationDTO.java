package com.dcat23.loanmgmt.customers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "CustomerCreation",
        description = "Schema to hold new Customer details")
public record CustomerCreationDTO(

        @Size(min = 1, max = 100, message = "First name size must be 1 to 100")
        @NotBlank(message = "First name must not be empty")
        String firstName,

        @NotBlank(message = "Last name must not be empty")
        @Size(min = 1, max = 100, message = "Last name size must be 1 to 100")
        String lastName,

        @NotBlank(message = "Email must not be empty")
        @Email
        String email,

        @Size(min = 10, message = "Phone number must have at least 10")
        String phoneNumber,

        String address
) {
}
