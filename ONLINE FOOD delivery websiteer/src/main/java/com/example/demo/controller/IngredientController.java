package com.example.demo.controller;


import com.example.demo.Request.IngredientCategoryrequeust;
import com.example.demo.Request.IngredientRequest;
import com.example.demo.model.Ingredientaitem;
import com.example.demo.model.Ingredientcategory;
import com.example.demo.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {
    @Autowired
    private IngredientsService is;

    @PostMapping
    public ResponseEntity<Ingredientcategory> createingredientcategory(@RequestBody IngredientCategoryrequeust req) throws Exception {
        Ingredientcategory i= is.createingredients(req.getName(),req.getIdl());
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Ingredientaitem> createingredientitem@RequestBody IngredientRequest req) throws Exception {
        Ingredientaitem i= is.createingredientitem(req.getName(), req.getRestaurantid());
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Ingredientcategory> updateingredientstock(@PathVariable Long id) throws Exception {
Ingredientaitem i= is.updatestock(id);
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Ingredientcategory> getRestaurantingredients(@PathVariable Long id) throws Exception {
        Ingredientaitem i= (Ingredientaitem) is.findrestaurantingredients(id);

        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Ingredientcategory> getRestaurantingredientscategory(@PathVariable Long id) throws Exception {
        Ingredientaitem i= (Ingredientaitem) is.findingredientscategorybyrestaurantid(id);

        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

}
