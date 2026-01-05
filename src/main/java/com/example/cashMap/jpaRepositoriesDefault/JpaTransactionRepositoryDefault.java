package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaTransaction;
import com.example.cashMap.models.enums.TransactionKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaTransactionRepositoryDefault extends JpaRepository<JpaTransaction, Integer> {

    List<JpaTransaction> findByAccount_Id(Integer accountId);

    List<JpaTransaction> findByCategory_Id(Integer categoryId);

    List<JpaTransaction> findByKind(TransactionKind kind);

    List<JpaTransaction> findByTypeContainingIgnoreCase(String typePart);

    Optional<JpaTransaction> findByHash(String hash);

    @Query("select t from JpaTransaction t where extract(month from t.date) = :month")
    List<JpaTransaction> findByMonth(@Param("month") int month);
}
