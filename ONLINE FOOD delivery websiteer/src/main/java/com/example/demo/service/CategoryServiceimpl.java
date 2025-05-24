package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceimpl implements CategoryService{

    @Autowired
    private RestaurantService rs;

    @Autowired
    private CategoryRepository crs;


    @Override
    public Category createcategory(String name, Long id) throws Exception{
        Restaurant r= rs.getrestaurantByuserId(id);
        Category c=new Category();
        c.setName(name);
        c.setRestaurant(r);
        return crs.save(c);
    }

    @Override
    public List<Category> findcategorybyrestaurantid(Long id) throws Exception {
        Restaurant r= rs.getrestaurantByuserId(id);
        return crs.findByRestaurantId(r.getId());
    }

    @Override
    public Category findcategorybyid(Long id) throws Exception {
        Optional<Category> oc=crs.findById(id);
        if (oc.isEmpty()){
            throw new Exception("category not found");
        }
        return oc.get();
    }
}
