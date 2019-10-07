package com.nemchinovrp.serverproductmanagement.repository;

import com.nemchinovrp.serverproductmanagement.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
