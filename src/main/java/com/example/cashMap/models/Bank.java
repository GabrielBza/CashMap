package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Bank implements Serializable{
    private Integer bankId;
    private String bankName;
    private String shortName;
    private String countryCode;

    public Bank(Integer bankId, String bankName, String shortName, String countryCode) {
        notNull(bankName, "bankName must not be null");
        notNull(shortName, "shortName must not be null");
        notNull(countryCode, "countryCode must not be null");
        this.bankId = bankId;
        this.bankName = bankName;
        this.shortName = shortName;
        this.countryCode = countryCode;
    }

    public Bank(String bankName, String shortName, String countryCode) {
        notNull(bankName, "bankName must not be null");
        notNull(shortName, "shortName must not be null");
        notNull(countryCode, "countryCode must not be null");
        this.bankName = bankName;
        this.shortName = shortName;
        this.countryCode = countryCode;
    }

    public Bank(){

    }
}
