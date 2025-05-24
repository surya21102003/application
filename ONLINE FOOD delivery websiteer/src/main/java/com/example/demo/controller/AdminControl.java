package com.example.demo.controller;


import com.example.demo.Request.CreateRestaurantRequest;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.rersponse.MessageResponse;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminControl {
    @Autowired
    private RestaurantService res;

    @Autowired
    private UserService usr;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest req, @RequestHeader("Authorization") String jwt)throws Exception{
      User user=usr.findUserByJwtToken(jwt);
      Restaurant re=res.createrestaurant(req,user);
        return new ResponseEntity<>(re, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id,@RequestBody CreateRestaurantRequest req, @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
        Restaurant re=res.updateRestaurant(id,req);
        return new ResponseEntity<>(re, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<MessageResponse> deleteRestaurant(@PathVariable Long id,@RequestBody CreateRestaurantRequest req, @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
        res.deleRestaurant(id);
        MessageResponse mr=new MessageResponse();
        mr.setMessage("restauranet deleted successfully");
        return new ResponseEntity<>(mr, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<Restaurant> updateRestaurantstatus(@PathVariable Long id, @RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
       Restaurant rest= res.updaterestaurantStatus(id);
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }
    @PutMapping()
    public ResponseEntity<Restaurant> findRestaurantbyuserid(@RequestHeader("Authorization") String jwt)throws Exception{
        User user=usr.findUserByJwtToken(jwt);
        Restaurant rest= res.getrestaurantByuserId(user.getId());
        return new ResponseEntity<>(rest, HttpStatus.OK);
    }
}
