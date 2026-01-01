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
    private Integer transactionId;
    private String type;
    private TransactionKind kind;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private Integer accountId;
    private String fromTo;
    private String notes;
    private Integer categoryId;
    private LocalDate postedDate;
    private String hash;

    public Transaction(Integer transactionId, String type, TransactionKind kind, BigDecimal amount, LocalDateTime transactionDate, Integer accountId, String fromTo, String notes, Integer categoryId, LocalDate postedDate, String hash) {
        notNull(type, "type must not be null");
        notNull(kind, "kind must not be null");
        notNull(amount, "amount must not be null");
        notNull(transactionDate, "transactionDate must not be null");
        this.transactionId = transactionId;
        this.type = type;
        this.kind = kind;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
        this.fromTo = fromTo;
        this.notes = notes;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
        this.hash = hash;
    }

    public Transaction(String type, TransactionKind kind, BigDecimal amount, LocalDateTime transactionDate, Integer accountId, String fromTo, String notes, Integer categoryId, LocalDate postedDate, String hash) {
        notNull(type, "type must not be null");
        notNull(kind, "kind must not be null");
        notNull(amount, "amount must not be null");
        notNull(transactionDate, "transactionDate must not be null");
        this.type = type;
        this.kind = kind;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
        this.fromTo = fromTo;
        this.notes = notes;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
        this.hash = hash;
    }

    public Transaction(String type, TransactionKind kind, BigDecimal amount, LocalDateTime transactionDate, Integer accountId, String fromTo, String notes, Integer categoryId, LocalDate postedDate) {
        notNull(type, "type must not be null");
        notNull(kind, "kind must not be null");
        notNull(amount, "amount must not be null");
        notNull(transactionDate, "transactionDate must not be null");
        this.type = type;
        this.kind = kind;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountId = accountId;
        this.fromTo = fromTo;
        this.notes = notes;
        this.categoryId = categoryId;
        this.postedDate = postedDate;
    }

    public Transaction(){

    }
}
