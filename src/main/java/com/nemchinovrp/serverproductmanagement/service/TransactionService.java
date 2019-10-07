package com.nemchinovrp.serverproductmanagement.service;

import com.nemchinovrp.serverproductmanagement.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);

    Long numberOfTransactions();

    List<Transaction> findAllTransactions();
}
