package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Goal implements Serializable{
    private Integer id;
    private String title;
    private String description;
    private BigDecimal targetValue;
    private BigDecimal currentValue;
    private LocalDate startDate;
    private LocalDate deadlineDate;
    private Integer accountId;
    private String status;

    public Goal(Integer id, String title, String description, BigDecimal targetValue, BigDecimal currentValue, LocalDate startDate, LocalDate deadlineDate, Integer accountId, String status) {
        notNull(title, "title must not be null");
        notNull(startDate, "startDate must not be null");
        notNull(status, "status must not be null");
        this.id = id;
        this.title = title;
        this.description = description;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.accountId = accountId;
        this.status = status;
    }

    public Goal(String title, String description, BigDecimal targetValue, BigDecimal currentValue, LocalDate startDate, LocalDate deadlineDate, Integer accountId, String status) {
        notNull(title, "title must not be null");
        notNull(startDate, "startDate must not be null");
        notNull(status, "status must not be null");
        this.title = title;
        this.description = description;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.startDate = startDate;
        this.deadlineDate = deadlineDate;
        this.accountId = accountId;
        this.status = status;
    }

    public Goal (){

    }
}
