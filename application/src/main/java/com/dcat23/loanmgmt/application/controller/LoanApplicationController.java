package com.dcat23.loanmgmt.application.controller;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationResponse;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.service.client.LoanApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "REST APIs for Loan Applications",
        description = "REST APIs to CREATE, UPDATE, FETCH and CANCEL Loan Applications")
@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @PostMapping
    @Operation(
            summary = "Create Loan Application",
            description = "REST API to create a loan application")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED")
    public ResponseEntity<LoanApplicationResponse> createLoanApplication(@Valid @RequestBody LoanApplicationCreationDTO loanApplicationDTO) {
        LoanApplicationResponse savedLoanApplication = loanApplicationService
                .createLoanApplication(loanApplicationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoanApplication);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Loan Application By Id",
            description = "REST API to fetch loan application details")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<LoanApplicationResponse> getLoanApplicationById(@PathVariable Long id) {
        LoanApplicationResponse loanApplication = loanApplicationService
                .getLoanApplicationById(id);
        return ResponseEntity.ok(loanApplication);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(
            summary = "Get Loan Applications By Customer Id",
            description = "REST API to fetch all loans by customer id")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<List<LoanApplicationResponse>> getLoanApplicationsByCustomerId(@PathVariable Long customerId) {
        List<LoanApplicationResponse> loanApplications = loanApplicationService
                .getLoanApplicationsByCustomerId(customerId);
        return ResponseEntity.ok(loanApplications);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Loan Application",
            description = "REST API to update existing loan application details")

    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    public ResponseEntity<LoanApplicationResponse> updateLoanApplication(@PathVariable Long id,
                                                                         @Valid @RequestBody LoanApplicationUpdateDTO loanApplicationUpdateDTO) {
        LoanApplicationResponse updatedLoanApplication = loanApplicationService
                .updateLoanApplication(id, loanApplicationUpdateDTO);
        return ResponseEntity.ok(updatedLoanApplication);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Cancel Loan Application",
            description = "REST API to cancel a loan application")
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status NO CONTENT")
    public ResponseEntity<Void> cancelLoanApplication(@PathVariable Long id) {
        loanApplicationService.cancelLoanApplication(id);
        return ResponseEntity.noContent().build();
    }
}

