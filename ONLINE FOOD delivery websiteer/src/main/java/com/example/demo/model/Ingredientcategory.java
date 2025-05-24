package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredientcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String name;
    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Ingredientaitem> ingredients=new ArrayList<>();

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

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

    public List<Ingredientaitem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredientaitem> ingredients) {
        this.ingredients = ingredients;
    }
}
