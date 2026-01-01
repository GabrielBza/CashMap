package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Category implements Serializable{
    private Integer categoryId;
    private String categoryName;

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(){

    }
}
