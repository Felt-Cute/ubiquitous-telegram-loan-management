package com.dcat23.loanmgmt.processing.repository;

import com.dcat23.loanmgmt.processing.model.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, Long> {
}
