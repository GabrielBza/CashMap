package com.example.cashMap.repositories;

import com.example.cashMap.models.GoalLog;
import com.example.cashMap.models.enums.GoalModType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GoalLogRepository {

    GoalLog save(GoalLog goalLog);

    Optional<GoalLog> findById(Integer id);

    List<GoalLog> findAll();

    List<GoalLog> findByGoalId(Integer goalId);

    List<GoalLog> findByModType(GoalModType modType);

    List<GoalLog> findByModDate(LocalDate modDate);

    void deleteById(Integer id);
}
