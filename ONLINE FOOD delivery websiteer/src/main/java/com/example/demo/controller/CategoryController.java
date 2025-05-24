package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categoryfood")
public class CategoryController {
    @Autowired
    private UserService us;

    @Autowired
    private CategoryService cs;

    @PostMapping
    public ResponseEntity<Category> createcategory(@RequestBody Category c,
                                                   @RequestHeader("Authorization") String jwt)throws Exception{
        User u=us.findUserByJwtToken(jwt);
        Category cd= cs.createcategory(c.getName(), u.getId());
return new ResponseEntity<>(cd,HttpStatus.CONTINUE);
    }
    @GetMapping
    public ResponseEntity<List<Category>> getrestaurantcategory(
                                                   @RequestHeader("Authorization") String jwt)throws Exception{
        User u=us.findUserByJwtToken(jwt);

        List<Category> cd= cs.findcategorybyrestaurantid(u.getId());

        return new ResponseEntity<>(cd,HttpStatus.CONTINUE);
    }

}
