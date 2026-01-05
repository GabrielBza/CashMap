package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaGoal;
import com.example.cashMap.jpaModels.JpaGoalLog;
import com.example.cashMap.models.GoalLog;

public class GoalLogMapper {

    private GoalLogMapper() {}

    public static GoalLog toGoalLog(JpaGoalLog jpaGoalLog) {
        if (jpaGoalLog == null) return null;

        GoalLog log = new GoalLog();
        log.setId(jpaGoalLog.getId());
        log.setGoalId(jpaGoalLog.getGoal() != null ? jpaGoalLog.getGoal().getId() : null);
        log.setModDate(jpaGoalLog.getModDate());
        log.setModType(jpaGoalLog.getModType());
        log.setOldInformation(jpaGoalLog.getOldInformation());
        log.setNewInformation(jpaGoalLog.getNewInformation());
        return log;
    }

    // Reminder for future errors (I know I will forget about this): Search for the goal by its Id when calling this function
    public static JpaGoalLog toJpaGoalLog(GoalLog goalLog, JpaGoal goal) {
        if (goalLog == null) return null;

        JpaGoalLog jpaGoalLog = new JpaGoalLog();
        jpaGoalLog.setId(goalLog.getId()); // null em criação, BD gera
        jpaGoalLog.setGoal(goal);          // obrigatório
        jpaGoalLog.setModDate(goalLog.getModDate());
        jpaGoalLog.setModType(goalLog.getModType());
        jpaGoalLog.setOldInformation(goalLog.getOldInformation());
        jpaGoalLog.setNewInformation(goalLog.getNewInformation());
        return jpaGoalLog;
    }
}
