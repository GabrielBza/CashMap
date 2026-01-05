package com.example.cashMap.mappers;

import com.example.cashMap.jpaModels.JpaAccount;
import com.example.cashMap.jpaModels.JpaImport;
import com.example.cashMap.models.Import;

public class ImportMapper {

    private ImportMapper() {}

    public static Import toImport(JpaImport jpaImport) {
        if (jpaImport == null) return null;

        Import imp = new Import();
        imp.setId(jpaImport.getId());
        imp.setAccountId(jpaImport.getAccount() != null ? jpaImport.getAccount().getId() : null);
        imp.setFileName(jpaImport.getFileName());
        imp.setFileHash(jpaImport.getFileHash());
        imp.setImportedDate(jpaImport.getImportedDate());
        return imp;
    }

    // Reminder for future errors (I know i will forget about this): Search for the account by its Id when calling this function
    public static JpaImport toJpaImport(Import imp, JpaAccount account) {
        if (imp == null) return null;

        JpaImport jpaImport = new JpaImport();
        jpaImport.setId(imp.getId());
        jpaImport.setAccount(account);
        jpaImport.setFileName(imp.getFileName());
        jpaImport.setFileHash(imp.getFileHash());
        jpaImport.setImportedDate(imp.getImportedDate());
        return jpaImport;
    }
}
