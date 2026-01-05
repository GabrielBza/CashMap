package com.example.cashMap.jpaRepositoriesDefault;

import com.example.cashMap.jpaModels.JpaGoal;
import com.example.cashMap.models.enums.GoalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaGoalRepositoryDefault extends JpaRepository<JpaGoal, Integer> {

    List<JpaGoal> findByTitleContainingIgnoreCase(String titlePart);

    List<JpaGoal> findByStatus(GoalStatus status);

    List<JpaGoal> findByAccount_Id(Integer accountId);
}
