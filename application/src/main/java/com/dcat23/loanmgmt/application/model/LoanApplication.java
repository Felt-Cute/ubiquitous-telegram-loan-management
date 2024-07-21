package com.dcat23.loanmgmt.application.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false, name = "interest_rate")
    private Double interestRate;

    @Column(nullable = false, name = "term")
    private Integer term;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated
    @Column(nullable = false, name = "status")
    private LoanStatus status;
    @Column(nullable = false, name = "customer_id")
    private Long customerId;

}
