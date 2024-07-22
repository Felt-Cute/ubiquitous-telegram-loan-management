package com.dcat23.loanmgmt.creditassessment.controller;

import com.dcat23.loanmgmt.creditassessment.dto.CreditAssessmentCreationDTO;
import com.dcat23.loanmgmt.creditassessment.dto.CreditAssessmentUpdateDTO;
import com.dcat23.loanmgmt.creditassessment.model.CreditAssessment;
import com.dcat23.loanmgmt.creditassessment.service.CreditAssessmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/credit-assessments")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CreditAssessmentController {

    private final CreditAssessmentService creditAssessmentService;

    @PostMapping
    @Operation(
                summary = "Create Credit Assessment",
                description = "REST API to save a credit assessment")
    @ApiResponse(
                responseCode = "201",
                description = "HTTP Status CREATED")
    public ResponseEntity<CreditAssessment> createCreditAssessment(@Valid @RequestBody CreditAssessmentCreationDTO creditAssessmentDTO) {
        CreditAssessment savedCreditAssessment = creditAssessmentService.saveCreditAssessment(creditAssessmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCreditAssessment);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Credit Assessment By Id",
                description = "REST API to fetch individual credit assessment")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<CreditAssessment> getCreditAssessmentById(@PathVariable Long id) {
        CreditAssessment creditAssessment = creditAssessmentService.getCreditAssessmentById(id);
        return ResponseEntity.ok(creditAssessment);
    }

    @GetMapping("/application/{applicationId}")
    @Operation(
                summary = "Get Credit Assessment By Application Id",
                description = "REST API to fetch assessment by individual application")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<CreditAssessment> getCreditAssessmentByApplicationId(@PathVariable Long applicationId) {
        CreditAssessment creditAssessment = creditAssessmentService.getCreditAssessmentByApplicationId(applicationId);
        return ResponseEntity.ok(creditAssessment);
    }

    @PutMapping("/{id}")
    @Operation(
                summary = "Update Credit Assessment",
                description = "REST API to update a credit assessment")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<CreditAssessment> updateCreditAssessment(@PathVariable Long id, @Valid @RequestBody CreditAssessmentUpdateDTO creditAssessmentDTO) {
        CreditAssessment updatedCreditAssessment = creditAssessmentService.updateCreditAssessment(id, creditAssessmentDTO);
        return ResponseEntity.ok(updatedCreditAssessment);
    }
}

