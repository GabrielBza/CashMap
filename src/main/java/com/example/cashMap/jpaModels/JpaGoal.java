package com.example.cashMap.jpaModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "goals")
public class JpaGoal implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "target_value", precision = 14, scale = 2, nullable = false)
    private BigDecimal targetValue;

    @Column(name = "current_value", precision = 14, scale = 2, nullable = false)
    private BigDecimal currentValue;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "deadline_date", nullable = true)
    private LocalDate deadlineDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = true)
    private JpaAccount account;


    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaGoalLog> logs;

    public JpaGoal(){

    }
}
