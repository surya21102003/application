package com.example.demo.service;

import com.example.demo.Request.CreateFoodRequest;
import com.example.demo.model.Category;
import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.FoodRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepositpory frep;

    private Restaurant res;


    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        Food food=new Food();
        food.setFoodcategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setIngredientaitem(req.getIngredients());
        food.setIsseasonable(req.isSeasional());
        food.setIsvegeterian(req.isVegetarin());
        food.setPrice(req.getPrice());
        Food sf=frep.save(food);
        res.getFoods().add(sf);
        return sf;
    }

    @Override
    public void deletefood(Long foodid) throws Exception {
Food f=findfoodnyid(foodid);
f.setRestaurant(null);
frep.save(f);
    }

    @Override
    public List<Food> geterestaurantsfood(Long restid, boolean isveg, boolean isnonveg, boolean isseasonel, String foodCategory) {
       List<Food> f=frep.findByRestaurantId(restid);
       if (isveg){
        f=FilterByVegetarian(f,isveg)   ;
       }
       if (isnonveg){
           f=FilterBynonVegetarian(f,isnonveg);
       }
       if (isseasonel){
           f=FilterBySeasonal(f,isseasonel);
       }
       if (foodCategory!=null && !foodCategory.equals("")){
           f=FilterByCategory(f,foodCategory);
       }
        return f;
    }

    private List<Food> FilterByCategory(List<Food> f, String foodCategory) {
        return f.stream().filter(fd->{
            if (fd.getFoodcategory()!=null){
                return fd.getFoodcategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> FilterBySeasonal(List<Food> f, boolean isseasonel) {
        return  f.stream().filter(fd-> fd.isIsseasonable()==isseasonel).collect(Collectors.toList());
    }

    private List<Food> FilterBynonVegetarian(List<Food> f, boolean isnonveg) {
        return  f.stream().filter(fd-> fd.isIsvegeterian()==false).collect(Collectors.toList());
    }

    private List<Food> FilterByVegetarian(List<Food> f, boolean isveg) {
        return  f.stream().filter(fd-> fd.isIsvegeterian()==isveg).collect(Collectors.toList());
    }

    @Override
    public List<Food> searchfood(String keyword) {
        return frep.searchFood(keyword);
    }

    @Override
    public Food findfoodnyid(Long foodid) throws Exception {
        Optional<Food>  of=frep.findById(foodid);
        if (of.isEmpty()){
            throw new Exception("not found");
        }
        return of.get();
    }

    @Override
    public Food updatefoodavailablity(Long foodid) throws Exception {
        Food f=findfoodnyid(foodid);
        f.setAvailable(!f.isAvailable());
        return frep.save(f);
    }
}
