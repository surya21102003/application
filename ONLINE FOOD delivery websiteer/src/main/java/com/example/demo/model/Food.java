package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String name;

    private  String description;

    private Long price;

    @ManyToOne
    private Category foodcategory;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

    private boolean available;

    @ManyToOne
    private Restaurant restaurant;

    private  boolean isvegeterian;
    private boolean isseasonable;

    @ManyToMany
    private List<Ingredientaitem> ingredientaitem;

    private Date creationdate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getFoodcategory() {
        return foodcategory;
    }

    public void setFoodcategory(Category foodcategory) {
        this.foodcategory = foodcategory;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isIsvegeterian() {
        return isvegeterian;
    }

    public void setIsvegeterian(boolean isvegeterian) {
        this.isvegeterian = isvegeterian;
    }

    public boolean isIsseasonable() {
        return isseasonable;
    }

    public void setIsseasonable(boolean isseasonable) {
        this.isseasonable = isseasonable;
    }

    public List<Ingredientaitem> getIngredientaitem() {
        return ingredientaitem;
    }

    public void setIngredientaitem(List<Ingredientaitem> ingredientaitem) {
        this.ingredientaitem = ingredientaitem;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}

