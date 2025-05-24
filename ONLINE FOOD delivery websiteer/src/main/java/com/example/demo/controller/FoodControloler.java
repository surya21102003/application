package com.example.demo.controller;


import com.example.demo.Request.CreateFoodRequest;
import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.FoodService;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodControloler {
    @Autowired
    private FoodService fs;

    @Autowired
    private UserService us;
    @Autowired
    private RestaurantService rs;

    @GetMapping()
    public ResponseEntity<List<Food>> searchfood(@RequestParam String n ,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);

        List<Food> f=fs.searchfood(n);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Food>> getrestaurantfood(@RequestParam boolean veg ,
                                                        @RequestParam boolean nonveg ,
                                                        @RequestParam boolean seasonal ,
                                                        @PathVariable Long id ,
                                                 @RequestParam (required = false) String fc,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);

        List<Food> f=fs.geterestaurantsfood(id,veg,nonveg,seasonal,fc);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }


}
