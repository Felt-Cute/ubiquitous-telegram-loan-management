package com.dcat23.loanmgmt.disbursements.controller;

import com.dcat23.loanmgmt.disbursements.dto.DisburseLoanDTO;
import com.dcat23.loanmgmt.disbursements.model.Disbursement;
import com.dcat23.loanmgmt.disbursements.model.DisbursementStatus;
import com.dcat23.loanmgmt.disbursements.service.DisbursementService;
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
        name = "CRUD REST APIs for Loan Disbursements",
        description = "REST APIs to UPDATE and FETCH Disbursements & Disburses Loans")
@RestController
@RequestMapping("/api/disbursements")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class DisbursementController {
    
    private final DisbursementService disbursementService;

    @PostMapping("/{loanId}/disburse")
    @Operation(
                summary = "Disburse Loan",
                description = "REST API to disburse a loan")
    @ApiResponse(
                responseCode = "202",
                description = "HTTP Status ACCEPTED")
    public ResponseEntity<Disbursement> disburseLoan(@PathVariable Long loanId, @Valid @RequestBody DisburseLoanDTO disburseLoanDTO ) {
        Disbursement savedDisbursement = disbursementService.disburseLoan(loanId, disburseLoanDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(savedDisbursement);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Disbursement By Id",
                description = "REST API to FETCH a disbursement")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Disbursement> getDisbursementById(@PathVariable Long id) {
        Disbursement disbursement = disbursementService.getDisbursementById(id);
        return ResponseEntity.ok(disbursement);
    }

    @GetMapping("/loan/{loanId}")
    @Operation(
                summary = "Get Disbursements By Loan Id",
                description = "REST API to FETCH disbursements for a specific loan")
    public ResponseEntity<List<Disbursement>> getDisbursementsByLoanId(@PathVariable Long loanId) {
        List<Disbursement> disbursements = disbursementService.getDisbursementsByLoanId(loanId);
        return ResponseEntity.ok(disbursements);
    }

    @PutMapping("/{id}")
    @Operation(
                summary = "Update Disbursement Status",
                description = "REST API to update the status of a Loan disbursement")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Disbursement> updateDisbursementStatus(@PathVariable Long id, @RequestParam DisbursementStatus status) {
        Disbursement updatedDisbursement = disbursementService.updateDisbursementStatus(id, status);
        return ResponseEntity.ok(updatedDisbursement);
    }
}
