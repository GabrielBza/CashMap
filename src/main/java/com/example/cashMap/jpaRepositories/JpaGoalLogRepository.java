package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaGoal;
import com.example.cashMap.jpaModels.JpaGoalLog;
import com.example.cashMap.jpaRepositoriesDefault.JpaGoalLogRepositoryDefault;
import com.example.cashMap.jpaRepositoriesDefault.JpaGoalRepositoryDefault;
import com.example.cashMap.mappers.GoalLogMapper;
import com.example.cashMap.models.GoalLog;
import com.example.cashMap.models.enums.GoalModType;
import com.example.cashMap.repositories.GoalLogRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaGoalLogRepository implements GoalLogRepository {

    private final JpaGoalLogRepositoryDefault logRepo;
    private final JpaGoalRepositoryDefault goalRepo;

    public JpaGoalLogRepository(JpaGoalLogRepositoryDefault logRepo,
                                JpaGoalRepositoryDefault goalRepo) {
        this.logRepo = logRepo;
        this.goalRepo = goalRepo;
    }

    @Override
    public GoalLog save(GoalLog goalLog) {
        notNull(goalLog, "GoalLog must not be null");
        notNull(goalLog.getGoalId(), "goalId must not be null");
        notNull(goalLog.getModDate(), "modDate must not be null");
        notNull(goalLog.getModType(), "modType must not be null");

        JpaGoal goal = goalRepo.findById(goalLog.getGoalId())
                .orElseThrow(() -> new IllegalArgumentException("Goal not found: " + goalLog.getGoalId()));

        JpaGoalLog saved = logRepo.save(GoalLogMapper.toJpaGoalLog(goalLog, goal));
        return GoalLogMapper.toGoalLog(saved);
    }

    @Override
    public Optional<GoalLog> findById(Integer id) {
        notNull(id, "id must not be null");
        return logRepo.findById(id).map(GoalLogMapper::toGoalLog);
    }

    @Override
    public List<GoalLog> findAll() {
        return logRepo.findAll().stream()
                .map(GoalLogMapper::toGoalLog)
                .toList();
    }

    @Override
    public List<GoalLog> findByGoalId(Integer goalId) {
        notNull(goalId, "goalId must not be null");

        return logRepo.findByGoal_Id(goalId).stream()
                .map(GoalLogMapper::toGoalLog)
                .toList();
    }

    @Override
    public List<GoalLog> findByModType(GoalModType modType) {
        notNull(modType, "modType must not be null");

        return logRepo.findByModType(modType).stream()
                .map(GoalLogMapper::toGoalLog)
                .toList();
    }

    @Override
    public List<GoalLog> findByModDate(LocalDate modDate) {
        notNull(modDate, "modDate must not be null");

        return logRepo.findByModDate(modDate).stream()
                .map(GoalLogMapper::toGoalLog)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        logRepo.deleteById(id);
    }
}
