package com.dcat23.loanmgmt.payments.service;

import com.dcat23.loanmgmt.payments.dto.TransactionCreationDTO;
import com.dcat23.loanmgmt.payments.dto.TransactionUpdateDTO;
import com.dcat23.loanmgmt.payments.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(TransactionCreationDTO transactionDTO);

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionsByLoanId(Long loanId);

    Transaction updateTransaction(Long id, TransactionUpdateDTO transactionDTO);
}
