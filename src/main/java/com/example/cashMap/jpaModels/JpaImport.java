package com.example.cashMap.jpaModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "imports")
public class JpaImport implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private JpaAccount account;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name="file_hash", nullable=false)
    private String fileHash;

    @Column(name = "imported_date", nullable = false)
    private LocalDate importedDate;

    public JpaImport(){

    }
}
