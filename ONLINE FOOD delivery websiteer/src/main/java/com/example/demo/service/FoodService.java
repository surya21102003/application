package com.example.demo.service;

import com.example.demo.Request.CreateFoodRequest;
import com.example.demo.model.Category;
import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
     void deletefood(Long foodid) throws Exception;
    public List<Food> geterestaurantsfood(Long restid,boolean isveg,boolean isnonveg,boolean isseasonel,String foodCategory);
    public List<Food> searchfood(String keyword);
    public Food findfoodnyid(Long foodid) throws Exception;
    public Food updatefoodavailablity(Long foodid)throws Exception;


}
