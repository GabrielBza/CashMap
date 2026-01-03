package com.example.cashMap.jpaModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class JpaAccount implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false)
    private JpaBank bank;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "current_balance", precision = 14, scale = 2, nullable = false)
    private BigDecimal currentBalance;

    @Column(name = "currency", length =3, nullable = false)
    private String currency;

    @Column(name = "status", nullable = false)
    private String status;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaImport> imports;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaTransaction> transactions;

    public JpaAccount(){

    }
}
