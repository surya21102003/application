package com.example.demo.Request;

import java.util.List;

public class AddCartItemRequest {
    private Long foodid;
    private int quantity;
    private List<String> ingredients;

    public Long getFoodid() {
        return foodid;
    }

    public void setFoodid(Long foodid) {
        this.foodid = foodid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
