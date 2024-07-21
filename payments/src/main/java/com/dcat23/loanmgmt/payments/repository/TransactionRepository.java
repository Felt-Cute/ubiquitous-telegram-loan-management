package com.dcat23.loanmgmt.payments.repository;

import com.dcat23.loanmgmt.payments.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
