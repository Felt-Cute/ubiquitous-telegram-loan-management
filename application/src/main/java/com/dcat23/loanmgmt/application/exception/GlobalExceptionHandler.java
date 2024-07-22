package com.dcat23.loanmgmt.application.exception;

import com.dcat23.loanmgmt.core.exception.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> genericExceptionHandler(
            Exception e,
            HttpServletRequest request
    ) {
        String message = String.format("%s: %s", e.getClass().getSimpleName(), e.getMessage());
        log.error(message);
        ErrorMessage errorMessage = new ErrorMessage(
                request.getRequestURI(),
                message,
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    }

    @ExceptionHandler(LoanProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> loanProductNotFoundExceptionHandler(
            LoanProductNotFoundException e,
            HttpServletRequest request
    ) {
        ErrorMessage errorMessage = new ErrorMessage(
                request.getRequestURI(),
                e.getMessage(),
                e.getStatusCode(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(e.getStatusCode()).body(errorMessage);
    }

    @ExceptionHandler(LoanProductRequirementException.class)
    public ResponseEntity<ErrorMessage> loanProductRequirementExceptionHandler(
            LoanProductRequirementException e,
            HttpServletRequest request
    ) {
        ErrorMessage errorMessage = new ErrorMessage(
                request.getRequestURI(),
                e.getDetails(),
                e.getStatusCode(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(e.getStatusCode()).body(errorMessage);
    }

    @ExceptionHandler(LoanApplicationNotFoundException.class)
    public ResponseEntity<ErrorMessage> loanApplicationNotFoundExceptionHandler(
            LoanApplicationNotFoundException e,
            HttpServletRequest request
    ) {
        ErrorMessage errorMessage = new ErrorMessage(
                request.getRequestURI(),
                e.getMessage(),
                e.getStatusCode(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(e.getStatusCode()).body(errorMessage);
    }
}
