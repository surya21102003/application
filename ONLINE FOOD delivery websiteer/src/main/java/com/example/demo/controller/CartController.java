package com.example.demo.controller;


import com.example.demo.Request.AddCartItemRequest;
import com.example.demo.Request.UpdateCartItemRequest;
import com.example.demo.model.Cart;
import com.example.demo.model.Cartitem;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cs;

    @Autowired
    private UserService us;
    @PutMapping()
    public ResponseEntity<Cartitem> additemcart(@RequestBody AddCartItemRequest req, @RequestHeader("Authorization") String jwt)throws Exception {
        Cartitem ci= cs.addotemtocart(req, jwt);
        return new ResponseEntity<>(ci, HttpStatus.CREATED);

    }
    @PutMapping()
    public ResponseEntity<Cartitem> updatecartitem(@RequestBody UpdateCartItemRequest req, @RequestHeader("Authorization") String jwt)throws Exception {
        Cartitem ci= cs.updateCartItemquantity(req.getCartitemid(), req.getQuantity());
        return new ResponseEntity<>(ci, HttpStatus.OK);

    }
    @PutMapping()
    public ResponseEntity<Cart> removecartitem(@PathVariable Long id, @RequestHeader("Authorization") String jwt)throws Exception {
        Cart ci= cs.rempvefromcart(id,jwt);
        return new ResponseEntity<>(ci, HttpStatus.OK);

    }
    @PutMapping()
    public ResponseEntity<Cartitem> clearcart( @RequestHeader("Authorization") String jwt)throws Exception {

        Cartitem ci = cs.clearCart(jwt);
        return new ResponseEntity<>(ci, HttpStatus.OK);

    }
    @PutMapping()
    public ResponseEntity<Cartitem> findusercart(@RequestBody AddCartItemRequest req, @RequestHeader("Authorization") String jwt)throws Exception {
        Cartitem ci= cs.addotemtocart(req, jwt);
        return new ResponseEntity<>(ci, HttpStatus.CREATED);

    }


}
