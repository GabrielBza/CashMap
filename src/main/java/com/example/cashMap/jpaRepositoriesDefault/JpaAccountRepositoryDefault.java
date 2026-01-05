package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.models.enums.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAccountRepositoryDefault extends JpaRepository<JpaAccount, Integer> {

    List<JpaAccount> findByNameContainingIgnoreCase(String namePart);

    List<JpaAccount> findByStatus(AccountStatus status);
}
