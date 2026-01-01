package com.example.cashMap.models;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import static org.springframework.util.Assert.notNull;

@Getter
@Setter
public class Bank implements Serializable{
    private Integer id;
    private String name;
    private String shortName;
    private String countryCode;

    public Bank(Integer id, String name, String shortName, String countryCode) {
        notNull(name, "name must not be null");
        notNull(shortName, "shortName must not be null");
        notNull(countryCode, "countryCode must not be null");
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.countryCode = countryCode;
    }

    public Bank(String name, String shortName, String countryCode) {
        notNull(name, "name must not be null");
        notNull(shortName, "shortName must not be null");
        notNull(countryCode, "countryCode must not be null");
        this.name = name;
        this.shortName = shortName;
        this.countryCode = countryCode;
    }

    public Bank(){

    }
}
