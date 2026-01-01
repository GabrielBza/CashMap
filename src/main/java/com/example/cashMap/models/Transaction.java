package com.example.cashMap.models;

import com.example.cashMap.models.enums.TransactionKind;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Transaction implements Serializable{
    private Integer id;
    private String type;
    private TransactionKind kind;
    private BigDecimal amount;
    private LocalDateTime date;
    private Integer accountId;
    private String fromTo;
    private String notes;
    private Integer categoryId;
    private LocalDate postedDate;
    private String hash;

    public Transaction(Integer id, String type, TransactionKind kind, BigDecimal amount, LocalDateTime date, Integer accountId, String fromTo, String notes, Integer categoryId, LocalDate postedDate, String hash) {
        notNull(type, "type must not be null");
        notNull(kind, "kind must not be null");
        notNull(amount, "amount must not be null");
        notNull(date, "date must not be null");
        this.id = id;
        this.type = type;
        this.kind = kind;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.fromTo = fromTo;
        this.notes = notes;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
        this.hash = hash;
    }

    public Transaction(String type, TransactionKind kind, BigDecimal amount, LocalDateTime date, Integer accountId, String fromTo, String notes, Integer categoryId, LocalDate postedDate, String hash) {
        notNull(type, "type must not be null");
        notNull(kind, "kind must not be null");
        notNull(amount, "amount must not be null");
        notNull(date, "date must not be null");
        this.type = type;
        this.kind = kind;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.fromTo = fromTo;
        this.notes = notes;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
        this.hash = hash;
    }

    public Transaction(String type, TransactionKind kind, BigDecimal amount, LocalDateTime date, Integer accountId, String fromTo, String notes, Integer categoryId, LocalDate postedDate) {
        notNull(type, "type must not be null");
        notNull(kind, "kind must not be null");
        notNull(amount, "amount must not be null");
        notNull(date, "date must not be null");
        this.type = type;
        this.kind = kind;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.fromTo = fromTo;
        this.notes = notes;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
    }

    public Transaction(){

    }
}
