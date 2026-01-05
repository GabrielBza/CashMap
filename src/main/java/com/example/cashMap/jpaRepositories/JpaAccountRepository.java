package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaBank;
import com.example.cashMap.jpaRepositoriesDefault.JpaAccountRepositoryDefault;
import com.example.cashMap.jpaRepositoriesDefault.JpaBankRepositoryDefault;
import com.example.cashMap.mappers.AccountMapper;
import com.example.cashMap.models.Account;
import com.example.cashMap.models.enums.AccountStatus;
import com.example.cashMap.repositories.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaAccountRepository implements AccountRepository {

    private final JpaAccountRepositoryDefault accountRepo;
    private final JpaBankRepositoryDefault bankRepo;

    public JpaAccountRepository(JpaAccountRepositoryDefault accountRepo,
                                JpaBankRepositoryDefault bankRepo) {
        this.accountRepo = accountRepo;
        this.bankRepo = bankRepo;
    }

    @Override
    public Account save(Account account) {
        notNull(account, "Account must not be null");
        notNull(account.getBankId(), "bankId must not be null");

        JpaBank bank = bankRepo.findById(account.getBankId())
                .orElseThrow(() -> new IllegalArgumentException("Bank not found: " + account.getBankId()));

        JpaAccount saved = accountRepo.save(AccountMapper.toJpaAccount(account, bank));
        return AccountMapper.toAccount(saved);
    }

    @Override
    public Optional<Account> findById(Integer id) {
        notNull(id, "id must not be null");
        return accountRepo.findById(id).map(AccountMapper::toAccount);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll().stream()
                .map(AccountMapper::toAccount)
                .toList();
    }

    @Override
    public List<Account> searchByName(String namePart) {
        notNull(namePart, "namePart must not be null");

        return accountRepo.findByNameContainingIgnoreCase(namePart).stream()
                .map(AccountMapper::toAccount)
                .toList();
    }

    @Override
    public List<Account> findByStatus(AccountStatus status) {
        notNull(status, "status must not be null");

        return accountRepo.findByStatus(status).stream()
                .map(AccountMapper::toAccount)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        accountRepo.deleteById(id);
    }
}
