package com.dcat23.loanmgmt.processing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "loan_histories")
public class LoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;


    @Column(nullable = false, name = "loan_id")
    private Long loanId; // Reference to the loan in LoanProcessingService

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "action_type")
    private LoanActionType actionType;

    @Column(nullable = false, name = "action_date")
    private LocalDate actionDate;

    @Column(nullable = false, name = "officer_id")
    private Long performedBy; // Reference to LoanOfficer in LoanProcessingService

}
