package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCategoryRepositoryDefault extends JpaRepository<JpaCategory, Integer> {

    List<JpaCategory> findByNameContainingIgnoreCase(String namePart);
}
