package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    public Category createcategory(String name,Long id)throws Exception;
    public List<Category> findcategorybyrestaurantid(Long id)throws Exception;
    public Category findcategorybyid(Long id)throws Exception;
}
