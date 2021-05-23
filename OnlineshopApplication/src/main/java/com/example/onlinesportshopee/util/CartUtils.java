package com.example.onlinesportshopee.util;

import java.util.ArrayList;

import java.util.List;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.model.Cart;


public class CartUtils {
	
	
	private CartUtils() {
        
    }
    
    public static List<Cart> convertToOrderDtoList(List<CartEntity> list){
        List<Cart> dtolist = new ArrayList<>();
        for(CartEntity cartEntity : list) 
            dtolist.add(convertToOrder(cartEntity));
        return dtolist;
    }
    
    public static CartEntity convertToOrder(Cart dto) {
    	CartEntity cart = new CartEntity();
    	
    	cart.setId(dto.getCartId());
        cart.setProductName(dto.getProductName());
        cart.setPrice(dto.getPrice());
        cart.setQuantity(dto.getQuantity());
        cart.setTotal(dto.getTotal());
        return cart;
    }        
    
    public static Cart convertToOrder(CartEntity cartEntity) {
    	Cart dto = new Cart();
    	dto.setCartId(cartEntity.getId());
        dto.setProductName(cartEntity.getProductName());
        dto.setPrice(cartEntity.getPrice());
        dto.setQuantity(cartEntity.getQuantity());
        dto.setTotal(cartEntity.getTotal());
        return dto;
    }

}
