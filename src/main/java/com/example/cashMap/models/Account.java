package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Account implements Serializable{
    private Integer id;
    private Integer bankId;
    private String name;
    private String description;
    private BigDecimal currentBalance;
    private String currency;
    private String status;


    public Account(Integer id, Integer bankId, String name, String description, BigDecimal currentBalance, String currency, String status){
        notNull(name, "account_name must not be null");
        notNull(currency, "currency must not be null");
        notNull(status, "status must not be null");
        this.id = id;
        this.bankId = bankId;
        this.name = name;
        this.description = description;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.status = status;
    }

    public Account(Integer bankId, String name, String description, BigDecimal currentBalance, String currency, String status){
        notNull(name, "account_name must not be null");
        notNull(currency, "currency must not be null");
        notNull(status, "status must not be null");
        this.bankId = bankId;
        this.name = name;
        this.description = description;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.status = status;
    }

    public Account(Integer bankId, String name, BigDecimal currentBalance, String currency, String status){
        notNull(name, "account_name must not be null");
        notNull(currency, "currency must not be null");
        notNull(status, "status must not be null");
        this.bankId = bankId;
        this.name = name;
        this.currentBalance = currentBalance;
        this.currency = currency;
        this.status = status;
    }

    public Account(){

    }
}
