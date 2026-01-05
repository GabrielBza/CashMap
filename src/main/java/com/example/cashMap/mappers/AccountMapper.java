package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaBank;
import com.example.cashMap.models.Account;

import java.math.BigDecimal;

public class AccountMapper {

    private AccountMapper() {}

    public static Account toAccount(JpaAccount jpaAccount) {
        if (jpaAccount == null) return null;

        Account account = new Account();
        account.setId(jpaAccount.getId());
        account.setBankId(jpaAccount.getBank() != null ? jpaAccount.getBank().getId() : null);
        account.setName(jpaAccount.getName());
        account.setDescription(jpaAccount.getDescription());
        account.setCurrentBalance(jpaAccount.getCurrentBalance());
        account.setCurrency(jpaAccount.getCurrency());
        account.setStatus(jpaAccount.getStatus());
        return account;
    }

    // Reminder for future errors (I know I will forget about this): Search for the bank by its Id when calling this function
    public static JpaAccount toJpaAccount(Account account, JpaBank bank) {
        if (account == null) return null;

        JpaAccount jpaAccount = new JpaAccount();
        jpaAccount.setId(account.getId());
        jpaAccount.setBank(bank);
        jpaAccount.setName(account.getName());
        jpaAccount.setDescription(account.getDescription());

        jpaAccount.setCurrentBalance(
                account.getCurrentBalance() != null ? account.getCurrentBalance() : BigDecimal.ZERO
        );

        jpaAccount.setCurrency(account.getCurrency());
        jpaAccount.setStatus(account.getStatus());
        return jpaAccount;
    }
}
