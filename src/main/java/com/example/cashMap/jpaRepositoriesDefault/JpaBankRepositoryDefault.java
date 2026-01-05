package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBankRepositoryDefault extends JpaRepository<JpaBank, Integer> {

    List<JpaBank> findByNameContainingIgnoreCase(String namePart);
}
