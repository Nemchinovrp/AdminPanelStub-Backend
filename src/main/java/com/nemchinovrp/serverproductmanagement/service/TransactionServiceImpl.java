package com.nemchinovrp.serverproductmanagement.service;

import com.nemchinovrp.serverproductmanagement.repository.TransactionRepository;
import com.nemchinovrp.serverproductmanagement.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(final Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Long numberOfTransactions() {
        return transactionRepository.count();
    }

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }
}
