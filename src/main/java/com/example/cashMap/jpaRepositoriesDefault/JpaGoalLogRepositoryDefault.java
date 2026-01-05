package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaGoalLog;
import com.example.cashMap.models.enums.GoalModType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaGoalLogRepositoryDefault extends JpaRepository<JpaGoalLog, Integer> {

    List<JpaGoalLog> findByGoal_Id(Integer goalId);

    List<JpaGoalLog> findByModType(GoalModType modType);

    List<JpaGoalLog> findByModDate(LocalDate modDate);
}
