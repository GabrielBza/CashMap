package com.example.cashMap.repositories;

import com.example.cashMap.models.Bank;

import java.util.List;
import java.util.Optional;

public interface BankRepository {
    Bank save(Bank bank);

    Optional<Bank> findById(Integer id);

    List<Bank> findAll();

    List<Bank> searchByName(String namePart);

    void deleteById(Integer id);
}
