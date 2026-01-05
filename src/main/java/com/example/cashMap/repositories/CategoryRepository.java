package com.example.cashMap.repositories;

import com.example.cashMap.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    Category save(Category category);

    Optional<Category> findById(Integer id);

    List<Category> findAll();

    List<Category> searchByName(String namePart);

    void deleteById(Integer id);
}
