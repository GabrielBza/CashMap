package com.example.cashMap.jpaModels;

import com.example.cashMap.models.enums.GoalModType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "goals_logs")
public class JpaGoalLog implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goal_id", referencedColumnName = "id", nullable = false)
    private JpaGoal goal;

    @Column(name = "mod_date", nullable = false)
    private LocalDate modDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "mod_type", nullable = false)
    private GoalModType modType;

    @Column(name = "old_information", nullable = true)
    private String oldInformation;

    @Column(name = "new_information", nullable = true)
    private String newInformation;

    public JpaGoalLog(){

    }
}
