package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaBank;
import com.example.cashMap.jpaRepositoriesDefault.JpaBankRepositoryDefault;
import com.example.cashMap.mappers.BankMapper;
import com.example.cashMap.models.Bank;
import com.example.cashMap.repositories.BankRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaBankRepository implements BankRepository {

    private final JpaBankRepositoryDefault bankRepo;

    public JpaBankRepository(JpaBankRepositoryDefault bankRepo) {
        this.bankRepo = bankRepo;
    }

    @Override
    public Bank save(Bank bank) {
        notNull(bank, "Bank must not be null");
        JpaBank saved = bankRepo.save(BankMapper.toJpaBank(bank));
        return BankMapper.toBank(saved);
    }

    @Override
    public Optional<Bank> findById(Integer id) {
        notNull(id, "id must not be null");
        return bankRepo.findById(id).map(BankMapper::toBank);
    }

    @Override
    public List<Bank> findAll() {
        return bankRepo.findAll().stream()
                .map(BankMapper::toBank)
                .toList();
    }

    @Override
    public List<Bank> searchByName(String namePart) {
        notNull(namePart, "namePart must not be null");

        return bankRepo.findByNameContainingIgnoreCase(namePart).stream()
                .map(BankMapper::toBank)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        bankRepo.deleteById(id);
    }
}
