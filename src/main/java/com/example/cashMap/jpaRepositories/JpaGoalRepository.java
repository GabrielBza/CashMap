package com.example.cashMap.jpaRepositories;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaGoal;
import com.example.cashMap.jpaRepositoriesDefault.JpaAccountRepositoryDefault;
import com.example.cashMap.jpaRepositoriesDefault.JpaGoalRepositoryDefault;
import com.example.cashMap.mappers.GoalMapper;
import com.example.cashMap.models.Goal;
import com.example.cashMap.models.enums.GoalStatus;
import com.example.cashMap.repositories.GoalRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Repository
public class JpaGoalRepository implements GoalRepository {

    private final JpaGoalRepositoryDefault goalRepo;
    private final JpaAccountRepositoryDefault accountRepo;

    public JpaGoalRepository(JpaGoalRepositoryDefault goalRepo,
                             JpaAccountRepositoryDefault accountRepo) {
        this.goalRepo = goalRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public Goal save(Goal goal) {
        notNull(goal, "Goal must not be null");
        notNull(goal.getTitle(), "title must not be null");
        notNull(goal.getStartDate(), "startDate must not be null");
        notNull(goal.getStatus(), "status must not be null");

        JpaAccount account = null;
        if (goal.getAccountId() != null) {
            account = accountRepo.findById(goal.getAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found: " + goal.getAccountId()));
        }

        JpaGoal saved = goalRepo.save(GoalMapper.toJpaGoal(goal, account));
        return GoalMapper.toGoal(saved);
    }

    @Override
    public Optional<Goal> findById(Integer id) {
        notNull(id, "id must not be null");
        return goalRepo.findById(id).map(GoalMapper::toGoal);
    }

    @Override
    public List<Goal> findAll() {
        return goalRepo.findAll().stream()
                .map(GoalMapper::toGoal)
                .toList();
    }

    @Override
    public List<Goal> searchByTitle(String titlePart) {
        notNull(titlePart, "titlePart must not be null");

        return goalRepo.findByTitleContainingIgnoreCase(titlePart).stream()
                .map(GoalMapper::toGoal)
                .toList();
    }

    @Override
    public List<Goal> findByStatus(GoalStatus status) {
        notNull(status, "status must not be null");

        return goalRepo.findByStatus(status).stream()
                .map(GoalMapper::toGoal)
                .toList();
    }

    @Override
    public List<Goal> findByAccountId(Integer accountId) {
        notNull(accountId, "accountId must not be null");

        return goalRepo.findByAccount_Id(accountId).stream()
                .map(GoalMapper::toGoal)
                .toList();
    }

    @Override
    public void deleteById(Integer id) {
        notNull(id, "id must not be null");
        goalRepo.deleteById(id);
    }
}
