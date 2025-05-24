package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredientaitem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private  String name;

    @ManyToOne
    private Ingredientcategory category;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private boolean instoke=true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredientcategory getCategory() {
        return category;
    }

    public void setCategory(Ingredientcategory category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isInstoke() {
        return instoke;
    }

    public void setInstoke(boolean instoke) {
        this.instoke = instoke;
    }
}
