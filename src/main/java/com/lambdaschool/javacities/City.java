package com.lambdaschool.javacities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class City {
    private @Id @GeneratedValue Long id;
    private String name;
    private long medianPrice;
    private int affordabilityIndex;

    public City() {

    }

    public City(String name, long medianPrice, int affordabilityIndex) {
        this.name = name;
        this.medianPrice = medianPrice;
        this.affordabilityIndex = affordabilityIndex;
    }
}

