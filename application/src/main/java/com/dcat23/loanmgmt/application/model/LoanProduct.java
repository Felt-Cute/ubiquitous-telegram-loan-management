package com.dcat23.loanmgmt.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "loan_products")
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name", unique = true)
    private String name;

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

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "loanProduct",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.REFRESH, CascadeType.DETACH}
    )
    private List<LoanApplication> applications = new ArrayList<>();

    public void addApplication(LoanApplication application) {
        if (applications == null) {
            applications = new ArrayList<>();
        }
        applications.add(application);
        application.setLoanProduct(this);
    }
}
