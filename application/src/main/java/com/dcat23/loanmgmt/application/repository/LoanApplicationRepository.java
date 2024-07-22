package com.dcat23.loanmgmt.application.repository;

import com.dcat23.loanmgmt.application.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
    List<LoanApplication> findAllByCustomerId(Long customerId);
}
