package com.dcat23.loanmgmt.application.controller;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import com.dcat23.loanmgmt.application.service.LoanApplicationService;
import com.dcat23.loanmgmt.core.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Loan Applications",
        description = "REST APIs to CREATE, UPDATE, FETCH and DELETE Loan Applications")
@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @PostMapping
    @Operation(
                summary = "Create Loan Application",
                description = "REST API to create a loan application")
    @ApiResponses({
        @ApiResponse(
                responseCode = "201",
                description = "HTTP Status CREATED"),
        @ApiResponse(
                responseCode = "404",
                description = "HTTP Status NOT FOUND",
                content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
        @ApiResponse(
                responseCode = "400",
                description = "HTTP Status BAD REQUEST",
                content = @Content(schema = @Schema(implementation = ErrorMessage.class))),
    })
    public ResponseEntity<LoanApplication> createLoanApplication(@Valid @RequestBody LoanApplicationCreationDTO loanApplicationDTO) {
        LoanApplication savedLoanApplication = loanApplicationService.createLoanApplication(loanApplicationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoanApplication);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Loan Application By Id",
                description = "REST API to fetch loan application details")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable Long id) {
        LoanApplication loanApplication = loanApplicationService.getLoanApplicationById(id);
        return ResponseEntity.ok(loanApplication);
    }

    @GetMapping("/customer/{userId}")
    @Operation(
                summary = "Get Loan Applications By Customer Id",
                description = "REST API to fetch all loans by customer id")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<List<LoanApplication>> getLoanApplicationsByUserId(@PathVariable Long userId) {
        List<LoanApplication> loanApplications = loanApplicationService.getLoanApplicationsByUserId(userId);
        return ResponseEntity.ok(loanApplications);
    }

    @PutMapping("/{id}")
    @Operation(
                summary = "Update Loan Application",
                description = "REST API to update existing loan application details")

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            )
    })
    public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable Long id, @Valid @RequestBody LoanApplicationUpdateDTO loanApplicationUpdateDTO) {
        LoanApplication updatedLoanApplication = loanApplicationService.updateLoanApplication(id, loanApplicationUpdateDTO);
        return ResponseEntity.ok(updatedLoanApplication);
    }

    @DeleteMapping("/{id}")
    @Operation(
                summary = "Delete Loan Application",
                description = "REST API to delete loan application")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status NO CONTENT")
    public ResponseEntity<Void> deleteLoanApplication(@PathVariable Long id) {
        loanApplicationService.deleteLoanApplication(id);
        return ResponseEntity.noContent().build();
    }
}

