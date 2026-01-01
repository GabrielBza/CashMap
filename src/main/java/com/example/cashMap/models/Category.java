package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Category implements Serializable{
    private Integer id;
    private String name;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(){

    }
}
