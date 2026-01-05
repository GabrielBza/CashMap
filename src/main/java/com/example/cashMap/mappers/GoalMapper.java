package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaGoal;
import com.example.cashMap.models.Goal;

import java.math.BigDecimal;

public class GoalMapper {

    private GoalMapper() {}

    public static Goal toGoal(JpaGoal jpaGoal) {
        if (jpaGoal == null) return null;

        Goal goal = new Goal();
        goal.setId(jpaGoal.getId());
        goal.setTitle(jpaGoal.getTitle());
        goal.setDescription(jpaGoal.getDescription());
        goal.setTargetValue(jpaGoal.getTargetValue());
        goal.setCurrentValue(jpaGoal.getCurrentValue());
        goal.setStartDate(jpaGoal.getStartDate());
        goal.setDeadlineDate(jpaGoal.getDeadlineDate());
        goal.setAccountId(jpaGoal.getAccount() != null ? jpaGoal.getAccount().getId() : null);
        goal.setStatus(jpaGoal.getStatus());
        return goal;
    }

    // Reminder for future errors (I know I will forget about this): Search for the account by its Id when calling this function (account is optional btw)
    public static JpaGoal toJpaGoal(Goal goal, JpaAccount account) {
        if (goal == null) return null;

        JpaGoal jpaGoal = new JpaGoal();
        jpaGoal.setId(goal.getId());
        jpaGoal.setTitle(goal.getTitle());
        jpaGoal.setDescription(goal.getDescription());
        jpaGoal.setTargetValue(goal.getTargetValue());
        jpaGoal.setCurrentValue(goal.getCurrentValue() != null ? goal.getCurrentValue() : BigDecimal.ZERO);
        jpaGoal.setStartDate(goal.getStartDate());
        jpaGoal.setDeadlineDate(goal.getDeadlineDate());
        jpaGoal.setAccount(account);
        jpaGoal.setStatus(goal.getStatus());
        return jpaGoal;
    }
}
