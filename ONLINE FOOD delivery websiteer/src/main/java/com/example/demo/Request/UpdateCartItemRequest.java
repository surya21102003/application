package com.example.demo.Request;

public class UpdateCartItemRequest {
    private Long cartitemid;
    private int quantity;

    public Long getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(Long cartitemid) {
        this.cartitemid = cartitemid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
