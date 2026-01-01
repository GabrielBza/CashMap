package com.example.cashMap.models;

import com.example.cashMap.models.enums.GoalModType;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class GoalLog implements Serializable{
    private Integer id;
    private Integer goalId;
    private LocalDate modDate;
    private GoalModType modType;
    private String oldInformation;
    private String newInformation;

    public GoalLog(Integer id, Integer goalId, LocalDate modDate, GoalModType modType, String oldInformation, String newInformation) {
        notNull(modDate, "modDate must not be null");
        notNull(modType, "modType must not be null");
        this.id = id;
        this.goalId = goalId;
        this.modDate = modDate;
        this.modType = modType;
        this.oldInformation = oldInformation;
        this.newInformation = newInformation;
    }

    public GoalLog(Integer goalId, LocalDate modDate, GoalModType modType, String oldInformation, String newInformation) {
        notNull(modDate, "modDate must not be null");
        notNull(modType, "modType must not be null");
        this.goalId = goalId;
        this.modDate = modDate;
        this.modType = modType;
        this.oldInformation = oldInformation;
        this.newInformation = newInformation;
    }

    public GoalLog(){

    }
}
