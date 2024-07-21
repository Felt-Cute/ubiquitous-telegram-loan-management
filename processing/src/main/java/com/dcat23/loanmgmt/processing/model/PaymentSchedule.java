package com.dcat23.loanmgmt.processing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "payment_schedules")
public class PaymentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;


    @Column(nullable = false, name = "loan_id")
    private Long loanId; // Reference to the loan in LoanProcessingService

    @Column(nullable = false, name = "payment_date")
    private LocalDate paymentDate;

    @Column(nullable = false, name = "payment_amount")
    private Double paymentAmount;

    @Column(nullable = false, name = "principal_amount")
    private Double principalAmount;

    @Column(nullable = false, name = "interest_amount")
    private Double interestAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private PaymentStatus status;
}
