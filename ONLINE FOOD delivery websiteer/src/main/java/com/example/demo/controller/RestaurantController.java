package com.example.demo.controller;

import com.example.demo.Request.CreateRestaurantRequest;
import com.example.demo.model.Restaurant;
import com.example.demo.model.RestaurantDto;
import com.example.demo.model.User;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService res;

    @Autowired
    private UserService usr;

    @GetMapping()
    public ResponseEntity<List<Restaurant>> searchRestaurant(@RequestParam String kerword , @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
       List< Restaurant> re=res.searchRestaurant(kerword);
        return new ResponseEntity<>(re, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getllRestaurant( @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
        List< Restaurant> re=res.getAllRestaurant();
        return new ResponseEntity<>(re, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Restaurant> findRestaurantbyid(@PathVariable Long id, @RequestParam String kerword , @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
         Restaurant re=  res.findbyrestaurantId(id);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<RestaurantDto> addtofavourates(@PathVariable Long id, @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
        RestaurantDto re=res.addToFavourite(id,user);
        return new ResponseEntity<>(re, HttpStatus.OK);
    }

}
