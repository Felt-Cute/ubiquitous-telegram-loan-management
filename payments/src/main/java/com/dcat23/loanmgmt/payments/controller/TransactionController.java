package com.dcat23.loanmgmt.payments.controller;

import com.dcat23.loanmgmt.payments.dto.TransactionCreationDTO;
import com.dcat23.loanmgmt.payments.dto.TransactionUpdateDTO;
import com.dcat23.loanmgmt.payments.model.Transaction;
import com.dcat23.loanmgmt.payments.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    @Operation(
                summary = "Create Transaction",
                description = "REST API to create a new transaction")
    @ApiResponse(
                responseCode = "201",
                description = "HTTP Status CREATED")
    public ResponseEntity<Transaction> createTransaction(@Valid @RequestBody TransactionCreationDTO transactionDTO) {
        Transaction savedTransaction = transactionService.createTransaction(transactionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTransaction);
    }

    @GetMapping("/{id}")
    @Operation(
                summary = "Get Transaction By Id",
                description = "REST API to FETCH an individual transaction")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/loan/{loanId}")
    @Operation(
                summary = "Get Transactions By Loan Id",
                description = "REST API to FETCH a transaction from a loan")
    public ResponseEntity<List<Transaction>> getTransactionsByLoanId(@PathVariable Long loanId) {
        List<Transaction> transactions = transactionService.getTransactionsByLoanId(loanId);
        return ResponseEntity.ok(transactions);
    }

    @PutMapping("/{id}")
    @Operation(
                summary = "Update Transaction",
                description = "REST API to update an existing Transaction")
    @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @Valid @RequestBody TransactionUpdateDTO transactionDTO) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDTO);
        return ResponseEntity.ok(updatedTransaction);
    }
}
