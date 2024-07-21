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

    @Column(nullable = false, name = "minAmount")
    private Double minAmount;

    @Column(nullable = false, name = "maxAmount")
    private Double maxAmount;

    @Column(nullable = false, name = "minTerm")
    private Integer minTerm;

    @Column(nullable = false, name = "maxTerm")
    private Integer maxTerm;
}
