package com.example.demo.service;

import com.example.demo.Request.AddCartItemRequest;
import com.example.demo.model.Cart;
import com.example.demo.model.Cartitem;
import com.example.demo.model.Food;
import com.example.demo.model.User;
import com.example.demo.repository.CartItemRepo;
import com.example.demo.repository.CartRepo;
import com.example.demo.repository.FoodRepositpory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartserviceImpl implements CartService{
    @Autowired
    private CartRepo cr;


    @Autowired
    private UserService us;

    @Autowired
    private CartItemRepo cir;
@Autowired
private FoodService fs;
    @Override
    public Cartitem addotemtocart(AddCartItemRequest req, String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);
        Food f=fs.findfoodnyid(req.getFoodid());
        Cart c=cr.findByCustomerId(u.getId());
        for (Cartitem ci :c.getItem()){
            if (ci.getFood().equals(f)){
                int nq=ci.getQuantity()+ req.getQuantity();
                return updateCartItemquantity(ci.getId(),nq);
            }
        }
        Cartitem nc=new Cartitem();
        nc.setFood(f);
        nc.setCart(c);
        nc.setQuantity(req.getQuantity());
        nc.setIngredients(req.getIngredients());
        nc.setPrice(req.getQuantity()* f.getPrice());
        Cartitem ci=cr.save(nc);
        c.getItem().add(ci);

        return ci;
    }

    @Override
    public Cartitem updateCartItemquantity(Long cartitemid, int quantity) throws Exception {
        Optional<Cartitem> ci=cir.findById(cartitemid);
        if (ci.isEmpty()){
            throw new Exception("not found");
        }
        Cartitem i=ci.get();
        i.setQuantity(quantity);
        i.setPrice(i.getFood().getPrice()*quantity);


        return cir.save(i);
    }

    @Override
    public Cart rempvefromcart(Long cartItemId, String jwt) throws Exception {
        User u=us.findUserByJwtToken(jwt);
        Cart c=cr.findByCustomerId(u.getId());
        Optional<Cartitem> ci=cir.findById(cartItemId);
        if (ci.isEmpty()){
            throw new Exception("cart item not found");
        }
        Cartitem i=ci.get();
        c.getItem().remove(i);
        return cr.save(c);
    }

    @Override
    public Long calculatecarttotals(Cart cart) throws Exception {
        Long t=0L;
        for (Cartitem ci: cart.getItem()){
            t+=ci.getFood().getPrice()*ci.getQuantity();
        }

        return t;
    }

    @Override
    public Cart findcartbyid(Long id) throws Exception {
        Optional<Cart> oc=cr.findById(id);
        if (oc.isEmpty()){
            throw new Exception("cart not found")
        }
        return oc.get();
    }

    @Override
    public Cart findCartByUserid(Long id) throws Exception {
        return cr.findByCustomerId(id);
    }

    @Override
    public Cart clearCart(String jwt) throws Exception {
        Cart c=findCartByUserid(id);
        c.getItem().clear();
        return cr.save(c);
    }
}
