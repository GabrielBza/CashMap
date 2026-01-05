package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaCategory;
import com.example.cashMap.jpaModels.JpaTransaction;
import com.example.cashMap.models.Transaction;

public class TransactionMapper {

    private TransactionMapper() {}

    public static Transaction toTransaction(JpaTransaction jpaTransaction) {
        if (jpaTransaction == null) return null;

        Transaction tx = new Transaction();
        tx.setId(jpaTransaction.getId());
        tx.setType(jpaTransaction.getType());
        tx.setKind(jpaTransaction.getKind());
        tx.setAmount(jpaTransaction.getAmount());
        tx.setDate(jpaTransaction.getDate());
        tx.setAccountId(jpaTransaction.getAccount() != null ? jpaTransaction.getAccount().getId() : null);
        tx.setFromTo(jpaTransaction.getFromTo());
        tx.setNotes(jpaTransaction.getNotes());
        tx.setCategoryId(jpaTransaction.getCategory() != null ? jpaTransaction.getCategory().getId() : null);
        tx.setPostedDate(jpaTransaction.getPostedDate());
        tx.setHash(jpaTransaction.getHash());
        return tx;
    }

    // Reminder for future errors (I know i will forget about this): Search for the account and category by its Id when calling this function
    public static JpaTransaction toJpaTransaction(Transaction tx, JpaAccount account, JpaCategory category) {
        if (tx == null) return null;

        JpaTransaction jpa = new JpaTransaction();
        jpa.setId(tx.getId());
        jpa.setType(tx.getType());
        jpa.setKind(tx.getKind());
        jpa.setAmount(tx.getAmount());
        jpa.setDate(tx.getDate());
        jpa.setAccount(account);
        jpa.setFromTo(tx.getFromTo());
        jpa.setNotes(tx.getNotes());
        jpa.setCategory(category);
        jpa.setPostedDate(tx.getPostedDate());
        jpa.setHash(tx.getHash());
        return jpa;
    }
}
