package com.example.cashMap.repositories;

import com.example.cashMap.models.Import;

import java.util.List;
import java.util.Optional;

public interface ImportRepository {

    Import save(Import imp);

    Optional<Import> findById(Integer id);

    List<Import> findAll();

    List<Import> findByAccountId(Integer accountId);

    List<Import> searchByAccountName(String accountNamePart);

    List<Import> findByMonth(int month);

    void deleteById(Integer id);
}
