package com.dcat23.loanmgmt.payments.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "loan_id")
    private Long loanId; // Reference to the loan in LoanProcessingService

    @Column(nullable = false, name = "amount")
    private Double amount;

    @Column(nullable = false, name = "transaction_date")
    private LocalDate transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "transaction_type")
    private TransactionType transactionType;

}
