package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Account implements Serializable{
    private Integer accountId;
    private Integer bankId;
    private String accountName;
    private String description;
    private BigDecimal currentBalance;
    private String currency;
    private String status;


    public Account(Integer accountId, Integer bankId, String accountName, String description, BigDecimal currentBalance, String currency, String status){
        notNull(accountName, "account_name must not be null");
        notNull(currency, "currency must not be null");
        notNull(status, "status must not be null");
        this.accountId = accountId;
        this.bankId = bankId;
        this.accountName = accountName;
        this.description = description;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.status = status;
    }

    public Account(Integer bankId, String accountName, String description, BigDecimal currentBalance, String currency, String status){
        notNull(accountName, "account_name must not be null");
        notNull(currency, "currency must not be null");
        notNull(status, "status must not be null");
        this.bankId = bankId;
        this.accountName = accountName;
        this.description = description;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.status = status;
    }

    public Account(Integer bankId, String accountName, BigDecimal currentBalance, String currency, String status){
        notNull(accountName, "account_name must not be null");
        notNull(currency, "currency must not be null");
        notNull(status, "status must not be null");
        this.bankId = bankId;
        this.accountName = accountName;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.status = status;
    }

    public Account(){

    }
}
