package com.lanou.bookstore.cart.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Cart implements Serializable {
    private HashMap<String,CartItem> cart;
    private Map<String, CartItem> map = new HashMap<>();

    public Cart(){
        HashMap<String,CartItem> cart = new HashMap<>();
        this.cart=cart;
    }

    public Map<String,CartItem> getCart(){
        return cart;
    }
    public Cart setCart(Map<String,CartItem>cart){
        this.cart= (HashMap<String, CartItem>) cart;
        return this;
    }

    public Map<String,CartItem>getMap(){
        return map;
    }

    public Map<String, CartItem> add(CartItem cartItem) {
        if (map.containsKey(cartItem.getBook().getBid())) {
            CartItem cartItem1 = map.get(cartItem.getBook().getBid());
            cartItem1.setCount(cartItem1.getCount() + cartItem.getCount());
            map.put(cartItem.getBook().getBid(), cartItem1);
        } else {
            map.put(cartItem.getBook().getBid(), cartItem);
        }
        return map;
    }

    public void clear() {
        map.clear();
    }

    public void delete(String bid) {
        map.remove(bid);
    }

    public Collection<CartItem> getCarItems() {
        return map.values();
    }

    public double getTotal(Map<String, CartItem> map) {
        BigDecimal total = new BigDecimal("0");
        for (CartItem cartItem : map.values()) {
            BigDecimal subtotal = new BigDecimal("" + cartItem.getSubtotal());
            total = total.add(subtotal);
        }
        return total.doubleValue();
    }
    public Map<String, CartItem> getCartItemMap() {
        return map;
    }


}

