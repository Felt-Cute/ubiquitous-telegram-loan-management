package com.dcat23.loanmgmt.officers.repository;

import com.dcat23.loanmgmt.officers.model.LoanOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanOfficerRepository extends JpaRepository<LoanOfficer, Long> {
}
