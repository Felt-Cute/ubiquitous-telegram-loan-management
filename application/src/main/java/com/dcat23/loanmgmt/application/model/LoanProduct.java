package com.dcat23.loanmgmt.application.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "loan_products")
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, name = "interest_rate")
    private Double interestRate;

    @Column(nullable = false, name = "min_amount")
    private Double minAmount;

    @Column(nullable = false, name = "max_amount")
    private Double maxAmount;

    @Column(nullable = false, name = "min_term")
    private Integer minTerm;

    @Column(nullable = false, name = "max_term")
    private Integer maxTerm;
}
