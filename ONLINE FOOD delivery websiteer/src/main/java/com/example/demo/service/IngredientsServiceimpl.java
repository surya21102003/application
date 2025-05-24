package com.example.demo.service;

import com.example.demo.model.Ingredientaitem;
import com.example.demo.model.Ingredientcategory;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.IngredientCategory;
import com.example.demo.repository.IngredientItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceimpl implements IngredientsService{
    @Autowired
    private IngredientCategory icr;

    @Autowired
    private IngredientItemRepo iir;

@Autowired
private RestaurantService rs;
    @Override
    public Ingredientcategory createingredients(String name, Long id) throws Exception {
        Restaurant s=rs.findbyrestaurantId(id);
        Ingredientcategory c=new Ingredientcategory();
        c.setRestaurant(s);
        c.setName(name);

        return icr.save(c);
    }

    @Override
    public Ingredientcategory findingredientcategoryid(Long id) throws Exception {
        Optional<IngredientCategory> opt=icr.findById(id);
        if (opt.isEmpty()){
            throw new Exception("ingredient category not found");
        }
        return (Ingredientcategory) opt.get();
    }

    @Override
    public List<Ingredientcategory> findingredientscategorybyrestaurantid(Long id) throws Exception {


        return icr.findByRestaurantId(id);
    }

    @Override
    public Ingredientaitem createingredientitem(Long id, String ingrenemae, Long categoryid) throws Exception {
        Restaurant s=rs.findbyrestaurantId(id);
        Ingredientaitem item=new Ingredientaitem();
        Ingredientcategory c=findingredientcategoryid(categoryid);
        item.setName(ingrenemae);
        item.setCategory(s);
        item.setRestaurant(c);

        Ingredientaitem i=IngredientItemRepo.save(item);
        c.getIngredients().add(i);

        return i;
    }

    @Override
    public List<Ingredientaitem> findrestaurantingredients(Long id) {
        return iir.findByRestaurantId(id);
    }

    @Override
    public Ingredientaitem updatestock(Long id) throws Exception {
        Optional<Ingredientaitem> opi=iir.findById(id);
        if (opi.isEmpty()){
            throw new Exception("ingredietn not found");
        }
        Ingredientaitem ii= opi.get();
        ii.setInstoke(!ii.isInstoke());
        return iir.save(ii);
    }
}
