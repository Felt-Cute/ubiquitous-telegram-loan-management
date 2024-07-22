package com.dcat23.loanmgmt.processing.controller;

import com.dcat23.loanmgmt.core.model.LoanStatus;
import com.dcat23.loanmgmt.processing.model.Loan;
import com.dcat23.loanmgmt.processing.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "REST APIs for Loan Processing",
        description = "REST APIs to CREATE, UPDATE, FETCH and Process Loans")
@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoanProcessingController {

    private final LoanService loanService;

    @PostMapping("/{applicationId}/process")
    @Operation(
                summary = "Process Loan Application",
                description = "REST API to process a loan")
    @ApiResponse(
                responseCode = "202",
                description = "HTTP Status ACCEPTED")
    public ResponseEntity<Loan> processLoanApplication(@PathVariable Long applicationId) {
        Loan processedLoan = loanService.processLoanApplication(applicationId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(processedLoan);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Loan By Id",
                description = "REST API to fetch loan by id")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Loan loan = loanService.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(
                summary = "Get Loans By Customer Id",
                description = "REST API to list all loans by customer")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<List<Loan>> getLoansByUserId(@PathVariable Long customerId) {
        List<Loan> loans = loanService.getLoansByUserId(customerId);
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/{id}")
    @Operation(
                summary = "Update Loan Status",
                description = "REST API to update loan status")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Loan> updateLoanStatus(@PathVariable Long id, @RequestParam LoanStatus status) {
        Loan updatedLoan = loanService.updateLoanStatus(id, status);
        return ResponseEntity.ok(updatedLoan);
    }

    @GetMapping
    @Operation(
                summary = "Search Loans By Status",
                description = "REST API to list all loans by status")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<List<Loan>> searchLoansByStatus(@RequestParam LoanStatus status) {
        List<Loan> loans = loanService.searchLoansByStatus(status);
        return ResponseEntity.ok(loans);
    }
}
