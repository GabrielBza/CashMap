package com.example.cashMap.jpaModels;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "banks")
public class JpaBank implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name", nullable = true)
    private String shortName;

    @Column(name = "country_code", length = 2, nullable = true)
    private String countryCode;


    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JpaAccount> accounts;

    public JpaBank(){

    }
}
