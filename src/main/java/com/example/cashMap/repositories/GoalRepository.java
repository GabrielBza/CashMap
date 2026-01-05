package com.example.cashMap.repositories;

import com.example.cashMap.models.Goal;
import com.example.cashMap.models.enums.GoalStatus;

import java.util.List;
import java.util.Optional;

public interface GoalRepository {

    Goal save(Goal goal);

    Optional<Goal> findById(Integer id);

    List<Goal> findAll();

    List<Goal> searchByTitle(String titlePart);

    List<Goal> findByStatus(GoalStatus status);

    List<Goal> findByAccountId(Integer accountId);

    void deleteById(Integer id);
}
