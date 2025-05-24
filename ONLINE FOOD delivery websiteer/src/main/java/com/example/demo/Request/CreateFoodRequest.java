package com.example.demo.Request;

import com.example.demo.model.Category;
import com.example.demo.model.Ingredientaitem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private Long restaurantid;
    private boolean vegetarin;
    private boolean seasional;
    private List<Ingredientaitem> ingredients;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public boolean isVegetarin() {
        return vegetarin;
    }

    public void setVegetarin(boolean vegetarin) {
        this.vegetarin = vegetarin;
    }

    public boolean isSeasional() {
        return seasional;
    }

    public void setSeasional(boolean seasional) {
        this.seasional = seasional;
    }

    public List<Ingredientaitem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredientaitem> ingredients) {
        this.ingredients = ingredients;
    }
}
