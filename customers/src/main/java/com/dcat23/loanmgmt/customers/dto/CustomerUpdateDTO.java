package com.dcat23.loanmgmt.customers.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "CustomerUpdate",
        description = "Schema to hold updated Customer details")
public record CustomerUpdateDTO(

        @Nullable
        @Size(min = 1, max = 100, message = "First name size must be 1 to 100")
        @NotBlank(message = "First name must not be empty")
        String firstName,

        @Nullable
        @Size(min = 1, max = 100, message = "Last name size must be 1 to 100")
        String lastName,

        @Nullable
        @Email
        String email,

        @Nullable
        @Size(min = 10, message = "Phone number must have at least 10")
        String phoneNumber,

        @Nullable
        String address

) {
}
