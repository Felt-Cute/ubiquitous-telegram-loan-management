package com.dcat23.loanmgmt.application.controller;

import com.dcat23.loanmgmt.application.dto.LoanApplicationCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanApplicationUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanApplication;
import com.dcat23.loanmgmt.application.service.LoanApplicationService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(
                summary = "Create Loan Application",
                description = "REST API to create a loan application")
    @ApiResponse(
                responseCode = "201",
                description = "HTTP Status CREATED")
    @PostMapping
    public ResponseEntity<LoanApplication> createLoanApplication(@Valid @RequestBody LoanApplicationCreationDTO loanApplicationDTO) {
        LoanApplication savedLoanApplication = loanApplicationService.createLoanApplication(loanApplicationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoanApplication);
    }

    @Operation(
                summary = "Get Loan Application By Id",
                description = "REST API to fetch loan application details")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    @GetMapping("/{id}")
    public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable Long id) {
        LoanApplication loanApplication = loanApplicationService.getLoanApplicationById(id);
        return ResponseEntity.ok(loanApplication);
    }

    @Operation(
                summary = "Get Loan Applications By Customer Id",
                description = "REST API to fetch all loans by customer id")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanApplication>> getLoanApplicationsByUserId(@PathVariable Long userId) {
        List<LoanApplication> loanApplications = loanApplicationService.getLoanApplicationsByUserId(userId);
        return ResponseEntity.ok(loanApplications);
    }

    @Operation(
                summary = "Update Loan Application",
                description = "REST API to update existing loan application details")

    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<LoanApplication> updateLoanApplication(@PathVariable Long id, @Valid @RequestBody LoanApplicationUpdateDTO loanApplicationUpdateDTO) {
        LoanApplication updatedLoanApplication = loanApplicationService.updateLoanApplication(id, loanApplicationUpdateDTO);
        return ResponseEntity.ok(updatedLoanApplication);
    }

    @Operation(
                summary = "Delete Loan Application",
                description = "REST API to delete loan application")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanApplication(@PathVariable Long id) {
        loanApplicationService.deleteLoanApplication(id);
        return ResponseEntity.noContent().build();
    }
}

