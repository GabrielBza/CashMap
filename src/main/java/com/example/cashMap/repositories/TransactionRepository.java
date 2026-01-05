package com.example.cashMap.repositories;

import com.example.cashMap.models.Transaction;
import com.example.cashMap.models.enums.TransactionKind;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    Transaction save(Transaction tx);

    Optional<Transaction> findById(Integer id);

    List<Transaction> findAll();

    List<Transaction> findByAccountId(Integer accountId);

    List<Transaction> findByCategoryId(Integer categoryId);

    List<Transaction> findByKind(TransactionKind kind);

    List<Transaction> searchByType(String typePart);

    Optional<Transaction> findByHash(String hash);

    List<Transaction> findByMonth(int month);

    void deleteById(Integer id);
}
