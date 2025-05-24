package com.example.demo.repository;

import com.example.demo.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepositpory extends JpaRepository<Food,Long> {
    List<Food> findByRestaurantId(Long RestaurantId);

    @Query("select f from food f where f.name Like %:keyword% or f.foodcategory.name like %:keyword%")
    List<Food> searchFood(@Param("keyword") String keyword);

}
