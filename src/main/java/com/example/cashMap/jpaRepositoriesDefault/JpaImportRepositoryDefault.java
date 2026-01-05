package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaImportRepositoryDefault extends JpaRepository<JpaImport, Integer> {

    List<JpaImport> findByAccount_Id(Integer accountId);

    List<JpaImport> findByAccount_NameContainingIgnoreCase(String accountNamePart);

    @Query("select i from JpaImport i where extract(month from i.importedDate) = :month")
    List<JpaImport> findByMonth(@Param("month") int month);
}
