package com.example.demo.controller;


import com.example.demo.Request.CreateFoodRequest;
import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.rersponse.MessageResponse;
import com.example.demo.service.FoodService;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminfoodController {
    @Autowired
    private FoodService fs;

    @Autowired
    private UserService us;
    @Autowired
    private RestaurantService rs;

    @PostMapping()
    public ResponseEntity<Food> createfood(@RequestBody CreateFoodRequest req ,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);
        Restaurant r= rs.findbyrestaurantId(req.getRestaurantid());
        Food f=fs.createFood(req,req.getCategory(),r);
    return new ResponseEntity<>(f, HttpStatus.CREATED);
    }
    @DeleteMapping()
    public ResponseEntity<MessageResponse> deletefood(@PathVariable Long id ,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);

        fs.deletefood(id);
        MessageResponse res=new MessageResponse();
        res.setMessage("deletesuccessfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<Food> updatefoodavailability(@PathVariable Long id ,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);

        Food f=fs.updatefoodavailablity(id);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }








    }

