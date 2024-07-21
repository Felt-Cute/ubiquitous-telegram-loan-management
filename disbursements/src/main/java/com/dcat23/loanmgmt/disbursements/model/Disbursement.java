package com.dcat23.loanmgmt.disbursements.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "disbursements")
public class Disbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disbursementId;

    @Column(nullable = false, name = "loan_id")
    private Long loanId; // Reference to the loan in LoanProcessingService

    @Column(nullable = false, name = "amount")
    private Double amount;

    @Column(nullable = false, name = "disbursement_date")
    private LocalDate disbursementDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private DisbursementStatus status;


}
