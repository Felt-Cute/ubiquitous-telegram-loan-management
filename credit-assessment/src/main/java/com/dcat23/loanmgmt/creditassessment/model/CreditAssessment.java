package com.dcat23.loanmgmt.creditassessment.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "credit_assessments")
public class CreditAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assessmentId;

    @Column(nullable = false, name = "loan_application_id")
    private Long loanApplicationId; // Reference to the loan application in LoanApplicationService

    @Column(nullable = false, name = "customer_id")
    private Long customerId; // Reference to the customer in User Service

    @Column(nullable = false, name = "result")
    private String assessmentResult;

    @Column(nullable = false, name = "taken_date")
    private LocalDate assessmentDate;

}
