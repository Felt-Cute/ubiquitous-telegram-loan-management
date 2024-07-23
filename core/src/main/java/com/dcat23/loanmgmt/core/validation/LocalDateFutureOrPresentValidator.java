package com.dcat23.loanmgmt.core.validation;

import com.dcat23.loanmgmt.core.validation.annotations.FutureOrPresentLocalDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class LocalDateFutureOrPresentValidator implements ConstraintValidator<FutureOrPresentLocalDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext context) {
        if (localDate == null) {
            return true; // Consider null as valid. Use @NotNull for null checks.
        }
        return !localDate.isBefore(LocalDate.now());
    }
}
