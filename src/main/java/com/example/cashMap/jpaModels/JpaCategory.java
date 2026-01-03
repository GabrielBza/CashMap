package com.example.cashMap.jpaModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class JpaCategory implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "category")
    private List<JpaTransaction> transactions;

    public JpaCategory(){

    }
}
