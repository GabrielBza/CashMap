package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaImport;
import com.example.cashMap.jpaRepositoriesDefault.JpaAccountRepositoryDefault;
import com.example.cashMap.jpaRepositoriesDefault.JpaImportRepositoryDefault;
import com.example.cashMap.mappers.ImportMapper;
import com.example.cashMap.models.Import;
import com.example.cashMap.repositories.ImportRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaImportRepository implements ImportRepository {

    private final JpaImportRepositoryDefault importRepo;
    private final JpaAccountRepositoryDefault accountRepo;

    public JpaImportRepository(JpaImportRepositoryDefault importRepo,
                               JpaAccountRepositoryDefault accountRepo) {
        this.importRepo = importRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public Import save(Import imp) {
        notNull(imp, "Import must not be null");
        notNull(imp.getAccountId(), "accountId must not be null");

        JpaAccount account = accountRepo.findById(imp.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found: " + imp.getAccountId()));

        JpaImport saved = importRepo.save(ImportMapper.toJpaImport(imp, account));
        return ImportMapper.toImport(saved);
    }

    @Override
    public Optional<Import> findById(Integer id) {
        notNull(id, "id must not be null");
        return importRepo.findById(id).map(ImportMapper::toImport);
    }

    @Override
    public List<Import> findAll() {
        return importRepo.findAll().stream()
                .map(ImportMapper::toImport)
                .toList();
    }

    @Override
    public List<Import> findByAccountId(Integer accountId) {
        notNull(accountId, "accountId must not be null");

        return importRepo.findByAccount_Id(accountId).stream()
                .map(ImportMapper::toImport)
                .toList();
    }

    @Override
    public List<Import> searchByAccountName(String accountNamePart) {
        notNull(accountNamePart, "accountNamePart must not be null");

        return importRepo.findByAccount_NameContainingIgnoreCase(accountNamePart).stream()
                .map(ImportMapper::toImport)
                .toList();
    }

    @Override
    public List<Import> findByMonth(int month) {
        validateMonth(month);

        return importRepo.findByMonth(month).stream()
                .map(ImportMapper::toImport)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        importRepo.deleteById(id);
    }

    private static void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month must be between 1 and 12");
        }
    }
}
