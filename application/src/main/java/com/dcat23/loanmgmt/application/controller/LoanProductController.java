package com.dcat23.loanmgmt.application.controller;

import com.dcat23.loanmgmt.application.dto.LoanProductCreationDTO;
import com.dcat23.loanmgmt.application.dto.LoanProductUpdateDTO;
import com.dcat23.loanmgmt.application.model.LoanProduct;
import com.dcat23.loanmgmt.application.service.LoanProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "REST APIs for Loan Products",
    description = "REST APIs to CREATE, UPDATE, FETCH and DELETE Loan Products")
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class LoanProductController {

    private final LoanProductService loanProductService;

    @GetMapping
    @Operation(
            summary = "Get All Loan Products",
            description = "REST API to FETCH Loan Products")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<List<LoanProduct>> getAllLoanProducts(){
        List<LoanProduct> products = loanProductService.getAllLoanProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Loan Product By Id",
            description = "REST API to FETCH a Loan Product")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<LoanProduct> getLoanProductById(@PathVariable Long id){
        LoanProduct product = loanProductService.getLoanProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    @Operation(
            summary = "Create Loan Product",
            description = "REST API to Create a new Loan Product")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED")
    public ResponseEntity<LoanProduct> createLoanProduct(@Valid @RequestBody LoanProductCreationDTO loanProductDTO){
        LoanProduct product = loanProductService.createLoanProduct(loanProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Loan Product",
            description = "REST API to update a Loan Product")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<LoanProduct> updateLoanProduct(@PathVariable Long id, @Valid @RequestBody LoanProductUpdateDTO loanProductDTO){
        LoanProduct updatedProduct = loanProductService.updateLoanProduct(id, loanProductDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Loan Product",
            description = "REST API to Delete a Loan Product")
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status NO CONTENT")
    public ResponseEntity<Void> deleteLoanProduct(@PathVariable Long id){
        loanProductService.deleteLoanProduct(id);
        return ResponseEntity.noContent().build();
    }
}
