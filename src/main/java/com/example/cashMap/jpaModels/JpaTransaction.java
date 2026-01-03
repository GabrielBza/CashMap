package com.example.cashMap.jpaModels;

import com.example.cashMap.models.enums.TransactionKind;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class JpaTransaction implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type", nullable = false)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "kind", nullable = false)
    private TransactionKind kind;

    @Column(name="amount", precision=14, scale=2, nullable=false)
    private BigDecimal amount;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private JpaAccount account;

    @Column(name = "from_to", nullable = true)
    private String fromTo;

    @Column(name = "notes", nullable = true)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = true)
    private JpaCategory category;

    @Column(name = "posted_date", nullable = true)
    private LocalDate postedDate;

    @Column(name = "hash", nullable = false)
    private String hash;

    public JpaTransaction(){

    }
}
