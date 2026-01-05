package com.example.cashMap.repositories;

import com.example.cashMap.models.Account;
import com.example.cashMap.models.enums.AccountStatus;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(Integer id);

    List<Account> findAll();

    List<Account> searchByName(String namePart);

    List<Account> findByStatus(AccountStatus status);

    void deleteById(Integer id);
}
