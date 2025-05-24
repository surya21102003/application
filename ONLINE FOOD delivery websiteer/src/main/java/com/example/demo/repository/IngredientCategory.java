package com.example.demo.repository;

import com.example.demo.model.Ingredientcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategory extends JpaRepository<IngredientCategory,Long> {
    List<Ingredientcategory> findByRestaurantId(Long id);
}
