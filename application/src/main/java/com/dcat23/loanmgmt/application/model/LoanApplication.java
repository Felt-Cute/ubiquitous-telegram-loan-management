package com.dcat23.loanmgmt.application.model;

import com.dcat23.loanmgmt.core.model.LoanStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "amount")
    private Double amount;

    @Column(nullable = false, name = "term")
    private Integer term;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private LoanStatus status = LoanStatus.PENDING;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "loan_product_id")
    private LoanProduct loanProduct;

    @Column(nullable = false, name = "customer_id")
    private Long customerId;

    @Column(name = "application_date")
    private LocalDate applicationDate;

}
