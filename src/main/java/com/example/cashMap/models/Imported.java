package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Imported implements Serializable{
    private Integer id;
    private Integer accountId;
    private String fileName;
    private String fileHash;
    private LocalDate importedDate;

    public Imported(Integer id, Integer accountId, String fileName, String fileHash, LocalDate importedDate) {
        notNull(fileName, "fileName must not be null");
        notNull(fileHash, "fileHash must not be null");
        notNull(importedDate, "importedDate must not be null");
        this.id = id;
        this.accountId = accountId;
        this.fileName = fileName;
        this.fileHash = fileHash;
        this.importedDate = importedDate;
    }

    public Imported(Integer accountId, String fileName, String fileHash, LocalDate importedDate) {
        notNull(fileName, "fileName must not be null");
        notNull(fileHash, "fileHash must not be null");
        notNull(importedDate, "importedDate must not be null");
        this.accountId = accountId;
        this.fileName = fileName;
        this.fileHash = fileHash;
        this.importedDate = importedDate;
    }

    public Imported(Integer id, Integer accountId, String fileName, LocalDate importedDate) {
        notNull(fileName, "fileName must not be null");
        notNull(importedDate, "importedDate must not be null");
        this.id = id;
        this.accountId = accountId;
        this.fileName = fileName;
        this.importedDate = importedDate;
    }

    public Imported(){

    }
}
