package com.dcat23.loanmgmt.disbursements.repository;

import com.dcat23.loanmgmt.disbursements.model.Disbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursementRepository extends JpaRepository<Disbursement, Long> {
}
