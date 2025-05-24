package com.example.demo.service;

import com.example.demo.model.Ingredientaitem;
import com.example.demo.model.Ingredientcategory;

import java.util.List;

public interface IngredientsService {
    public Ingredientcategory createingredients(String name,Long id)throws Exception;
    public Ingredientcategory findingredientcategoryid(Long  id)throws Exception;
    public List<Ingredientcategory> findingredientscategorybyrestaurantid(Long id)throws Exception;
    public Ingredientaitem createingredientitem(Long id,String ingrenemae,Long categoryid)throws Exception;
    public List<Ingredientaitem> findrestaurantingredients(Long id);
    public Ingredientaitem updatestock(Long id)throws Exception;
}
