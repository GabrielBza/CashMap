package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaCategory;
import com.example.cashMap.jpaModels.JpaTransaction;
import com.example.cashMap.jpaRepositoriesDefault.JpaAccountRepositoryDefault;
import com.example.cashMap.jpaRepositoriesDefault.JpaCategoryRepositoryDefault;
import com.example.cashMap.jpaRepositoriesDefault.JpaTransactionRepositoryDefault;
import com.example.cashMap.mappers.TransactionMapper;
import com.example.cashMap.models.Transaction;
import com.example.cashMap.models.enums.TransactionKind;
import com.example.cashMap.repositories.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaTransactionRepository implements TransactionRepository {

    private final JpaTransactionRepositoryDefault txRepo;
    private final JpaAccountRepositoryDefault accountRepo;
    private final JpaCategoryRepositoryDefault categoryRepo;

    public JpaTransactionRepository(JpaTransactionRepositoryDefault txRepo,
                                    JpaAccountRepositoryDefault accountRepo,
                                    JpaCategoryRepositoryDefault categoryRepo) {
        this.txRepo = txRepo;
        this.accountRepo = accountRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Transaction save(Transaction tx) {
        notNull(tx, "Transaction must not be null");
        notNull(tx.getType(), "type must not be null");
        notNull(tx.getKind(), "kind must not be null");
        notNull(tx.getAmount(), "amount must not be null");
        notNull(tx.getDate(), "date must not be null");
        notNull(tx.getAccountId(), "accountId must not be null");
        notNull(tx.getHash(), "hash must not be null");

        JpaAccount account = accountRepo.findById(tx.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + tx.getAccountId()));

        JpaCategory category = null;
        if (tx.getCategoryId() != null) {
            category = categoryRepo.findById(tx.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found: " + tx.getCategoryId()));
        }

        JpaTransaction saved = txRepo.save(TransactionMapper.toJpaTransaction(tx, account, category));
        return TransactionMapper.toTransaction(saved);
    }

    @Override
    public Optional<Transaction> findById(Integer id) {
        notNull(id, "id must not be null");
        return txRepo.findById(id).map(TransactionMapper::toTransaction);
    }

    @Override
    public List<Transaction> findAll() {
        return txRepo.findAll().stream()
                .map(TransactionMapper::toTransaction)
                .toList();
    }

    @Override
    public List<Transaction> findByAccountId(Integer accountId) {
        notNull(accountId, "accountId must not be null");

        return txRepo.findByAccount_Id(accountId).stream()
                .map(TransactionMapper::toTransaction)
                .toList();
    }

    @Override
    public List<Transaction> findByCategoryId(Integer categoryId) {
        notNull(categoryId, "categoryId must not be null");

        return txRepo.findByCategory_Id(categoryId).stream()
                .map(TransactionMapper::toTransaction)
                .toList();
    }

    @Override
    public List<Transaction> findByKind(TransactionKind kind) {
        notNull(kind, "kind must not be null");

        return txRepo.findByKind(kind).stream()
                .map(TransactionMapper::toTransaction)
                .toList();
    }

    @Override
    public List<Transaction> searchByType(String typePart) {
        notNull(typePart, "typePart must not be null");

        return txRepo.findByTypeContainingIgnoreCase(typePart).stream()
                .map(TransactionMapper::toTransaction)
                .toList();
    }

    @Override
    public Optional<Transaction> findByHash(String hash) {
        notNull(hash, "hash must not be null");
        return txRepo.findByHash(hash).map(TransactionMapper::toTransaction);
    }

    @Override
    public List<Transaction> findByMonth(int month) {
        validateMonth(month);

        return txRepo.findByMonth(month).stream()
                .map(TransactionMapper::toTransaction)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        txRepo.deleteById(id);
    }

    private static void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month must be between 1 and 12");
        }
    }
}
