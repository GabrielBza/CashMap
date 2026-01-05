package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaBank;
import com.example.cashMap.models.Bank;

public class BankMapper {

    private BankMapper() {}

    public static Bank toBank(JpaBank jpaBank) {
        if (jpaBank == null) return null;

        Bank bank = new Bank();
        bank.setId(jpaBank.getId());
        bank.setName(jpaBank.getName());
        bank.setShortName(jpaBank.getShortName());
        bank.setCountryCode(jpaBank.getCountryCode());
        return bank;
    }

    public static JpaBank toJpaBank(Bank bank) {
        if (bank == null) return null;

        JpaBank jpaBank = new JpaBank();
        jpaBank.setId(bank.getId());
        jpaBank.setName(bank.getName());
        jpaBank.setShortName(bank.getShortName());
        jpaBank.setCountryCode(bank.getCountryCode());
        return jpaBank;
    }
}
