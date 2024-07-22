package com.dcat23.loanmgmt.notifications.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(
        name = "NotificationCreation",
        description = "Schema to hold new Notification details")
public record NotificationCreationDTO(

        @NotBlank(message = "Customer id must not be empty")
        Long customerId,

        @NotBlank(message = "Message must not be empty")
        String message

) {
}
