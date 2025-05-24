package com.example.demo.service;

import com.example.demo.Request.AddCartItemRequest;
import com.example.demo.model.Cart;
import com.example.demo.model.Cartitem;

public interface CartService {
    public Cartitem addotemtocart(AddCartItemRequest req, String jwt)throws Exception;
    public Cartitem updateCartItemquantity(Long cartitemid,int quantity)throws Exception;
    public Cart rempvefromcart(Long cartItemId,String jwt)throws Exception;
    public Long calculatecarttotals(Cart cart)throws Exception;
    public Cart findcartbyid(Long id)throws Exception;
    public Cart findCartByUserid(Long id)throws Exception;
    public Cart clearCart(Long id)throws Exception;
}
