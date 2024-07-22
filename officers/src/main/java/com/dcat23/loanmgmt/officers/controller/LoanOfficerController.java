package com.dcat23.loanmgmt.officers.controller;

import com.dcat23.loanmgmt.officers.dto.LoanOfficerCreationDTO;
import com.dcat23.loanmgmt.officers.dto.LoanOfficerUpdateDTO;
import com.dcat23.loanmgmt.officers.model.LoanOfficer;
import com.dcat23.loanmgmt.officers.service.LoanOfficerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Loan Officers",
        description = "REST APIs to CREATE, UPDATE, FETCH and DELETE Loan Officers")
@RestController
@RequestMapping("/api/officers")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class LoanOfficerController {

    private final LoanOfficerService loanOfficerService;

    @PostMapping
    @Operation(
                summary = "Create Loan Officer",
                description = "REST API to create a Loan Officer")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status CREATED")
    public ResponseEntity<LoanOfficer> createLoanOfficer(@Valid @RequestBody LoanOfficerCreationDTO loanOfficerDTO) {
        LoanOfficer savedLoanOfficer = loanOfficerService.createLoanOfficer(loanOfficerDTO);
        return ResponseEntity.ok(savedLoanOfficer);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Loan Officer By Id",
                description = "REST API to FETCH a Loan Officer")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<LoanOfficer> getLoanOfficerById(@PathVariable Long id) {
        LoanOfficer loanOfficer = loanOfficerService.getLoanOfficerById(id);
        return ResponseEntity.ok(loanOfficer);
    }

    @PutMapping("/{id}")
    @Operation(
                summary = "Update Loan Officer",
                description = "REST API to update Loan Officer details")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<LoanOfficer> updateLoanOfficer(@PathVariable Long id, @Valid @RequestBody LoanOfficerUpdateDTO loanOfficerDTO) {
        LoanOfficer updatedLoanOfficer = loanOfficerService.updateLoanOfficer(id, loanOfficerDTO);
        return ResponseEntity.ok(updatedLoanOfficer);
    }

    @DeleteMapping("/{id}")
    @Operation(
                summary = "Delete Loan Officer",
                description = "REST API to delete a Loan Officer")
    @ApiResponse(
                responseCode = "204",
                description = "HTTP Status NO CONTENT")
    public ResponseEntity<Void> deleteLoanOfficer(@PathVariable Long id) {
        loanOfficerService.deleteLoanOfficer(id);
        return ResponseEntity.noContent().build();
    }
}
