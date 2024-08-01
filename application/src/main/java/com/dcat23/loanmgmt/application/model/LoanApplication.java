package com.dcat23.loanmgmt.application.model;

import com.dcat23.loanmgmt.core.model.LoanStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Table(name = "loan_applications",
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"customer_id", "loan_product_id"},
                name = "uc_customer_id_product_id")})
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

    @CreationTimestamp
    @Column(name = "application_date")
    private LocalDate applicationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanApplication that = (LoanApplication) o;
        return Objects.equals(id, that.id)
                && Objects.equals(amount, that.amount)
                && Objects.equals(term, that.term)
                && status == that.status
                && Objects.equals(getProductId(), that.getProductId())
                && Objects.equals(customerId, that.customerId)
                && Objects.equals(applicationDate, that.applicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, term, status, getProductId(), customerId, applicationDate);
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "id=" + id +
                ", amount=" + amount +
                ", term=" + term +
                ", status=" + status +
                ", loanProductId=" + getProductId() +
                ", customerId=" + customerId +
                ", applicationDate=" + applicationDate +
                '}';
    }

    private Long getProductId() {
        return loanProduct == null ? null : loanProduct.getId();
    }
}
