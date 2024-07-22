package com.dcat23.loanmgmt.payments.service;

import com.dcat23.loanmgmt.payments.dto.TransactionCreationDTO;
import com.dcat23.loanmgmt.payments.dto.TransactionUpdateDTO;
import com.dcat23.loanmgmt.payments.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    @Override
    public Transaction createTransaction(TransactionCreationDTO transactionDTO) {
        return null;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsByLoanId(Long loanId) {
        return List.of();
    }

    @Override
    public Transaction updateTransaction(Long id, TransactionUpdateDTO transactionDTO) {
        return null;
    }
}
