package com.example.demo.service;

import com.example.demo.Request.CreateRestaurantRequest;
import com.example.demo.model.Restaurant;
import com.example.demo.model.RestaurantDto;
import com.example.demo.model.User;

import java.util.List;

public interface RestaurantService {
    public Restaurant createrestaurant(CreateRestaurantRequest req, User user);
    public Restaurant updateRestaurant( Long restaurantId,CreateRestaurantRequest updatedRestaurant)throws Exception;
    public void deleRestaurant(Long restaurantId) throws Exception;
    public List<Restaurant> getAllRestaurant();
    public List<Restaurant> searchRestaurant(String Keywprd);
    public Restaurant findbyrestaurantId(long id)throws Exception;
    public Restaurant getrestaurantByuserId(Long id) throws Exception;
    public RestaurantDto addToFavourite(Long restaurantId,User user)throws Exception;
    public Restaurant updaterestaurantStatus(Long id)throws Exception;


}
